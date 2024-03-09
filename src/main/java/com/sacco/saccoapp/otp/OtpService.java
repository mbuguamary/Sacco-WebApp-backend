package com.sacco.saccoapp.otp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OtpService {
 private final OtpRepository otpRepository;
    public List<Otp> getOtp() {
      return  otpRepository.findAll();
    };

    public Otp addNewOtp(Otp otp) {
      return otpRepository.save(otp) ;
    }
}
