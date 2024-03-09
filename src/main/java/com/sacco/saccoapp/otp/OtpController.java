package com.sacco.saccoapp.otp;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/api/v1/otp")
@AllArgsConstructor
@RestController
public class OtpController {
    private final OtpService otpService;
    @GetMapping
    private List<Otp> getOtp(){
        return otpService.getOtp();
    }
   @PostMapping(path = "/register")
    public ResponseEntity<Otp> registerOtp(@RequestBody Otp otp){
        var token = otpService.addNewOtp(otp);
        return new ResponseEntity<>(token, HttpStatus.CREATED);
   }
}
