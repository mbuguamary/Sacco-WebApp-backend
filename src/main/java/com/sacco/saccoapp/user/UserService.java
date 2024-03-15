package com.sacco.saccoapp.user;

import com.sacco.saccoapp.otp.Otp;
import com.sacco.saccoapp.otp.OtpRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final OtpRepository otpRepository;
    @Transactional
    public User changePassword(ChangePasswordRequest changePasswordRequest) {


        User user= userRepository.findByMemberNo(changePasswordRequest.getMemberNo())
                .orElseThrow(()-> new IllegalStateException("Member with member No "+changePasswordRequest.getMemberNo()+" does not exists"));

       //Get the otp from the request, check against

        Optional<Otp> otpOptional = otpRepository.findByMemNo(changePasswordRequest.getMemberNo());
        if(otpOptional.isPresent()){
            Otp otp = otpOptional.get();

            if(!otp.getKeyUsed() && otp.getPassKey().equals(changePasswordRequest.getOtp())){
                user.setPassword(passwordEncoder.encode(changePasswordRequest.getPassword()));

                 otp.setKeyUsed(true);
                 otpRepository.save(otp);
                return userRepository.save(user);

            }

        }
        throw new RuntimeException("OTP not valid");

    }

}
