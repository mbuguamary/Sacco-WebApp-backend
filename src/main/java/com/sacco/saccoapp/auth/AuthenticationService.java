package com.sacco.saccoapp.auth;

import com.sacco.saccoapp.config.JwtService;
import com.sacco.saccoapp.otp.Otp;
import com.sacco.saccoapp.otp.OtpRepository;
import com.sacco.saccoapp.user.Role;
import com.sacco.saccoapp.user.User;
import com.sacco.saccoapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final OtpRepository otpRepository;
    private final UserRepository userRepository;

    public  AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMemberNo(),
                        request.getPassword()
                )
        );
        var user = repository.findByMemberNo(request.getMemberNo())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .memberNo(request.getMemberNo())
                .build();
    }


    public AuthenticationResponse register(RegisterRequest request) {
        User ActiveMember= userRepository.findByMemberNo(request.getMemberNo())
                .orElseThrow(()-> new IllegalStateException("Member with member No "+request.getMemberNo()+" does not exists"));
        Optional<Otp> otpOptional = otpRepository.findByMemNo(request.getMemberNo());
        if(otpOptional.isPresent()){
            Otp otp = otpOptional.get();

            if(!otp.getKeyUsed() && otp.getPassKey().equals(request.getOtp())){
                var user = User.builder()
                        .mobileNo(request.getMobileNo())
                        .memberNo(request.getMemberNo())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.USER)
                        .otp(request.getOtp())
                        .build();
                repository.save(user);
                otp.setKeyUsed(true);
                otpRepository.save(otp);
                var jwtToken = jwtService.generateToken(user);
                var member = request.getMemberNo();

                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .memberNo(member)
                        .build();
        }

        }

        throw new RuntimeException("OTP not valid");
    }
}
