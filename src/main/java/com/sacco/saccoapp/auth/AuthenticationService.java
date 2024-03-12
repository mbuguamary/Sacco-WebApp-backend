package com.sacco.saccoapp.auth;

import com.sacco.saccoapp.config.JwtService;
import com.sacco.saccoapp.user.Role;
import com.sacco.saccoapp.user.User;
import com.sacco.saccoapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

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
                .build();
    }


    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .mobileNo(request.getMobileNo())
                .memberNo(request.getMemberNo())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .otp(request.getOtp())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
      return AuthenticationResponse.builder()
              .token(jwtToken)
              .build();
    }
}
