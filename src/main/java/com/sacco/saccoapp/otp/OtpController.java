package com.sacco.saccoapp.otp;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(path="/api/v1/auth")
@AllArgsConstructor
@RestController
public class OtpController {
    private final OtpService otpService;
    @GetMapping(path = "/getOtp")
    private List<Otp> getOtp(){
        return otpService.getOtp();
    }
    @GetMapping(path = "/otp/{memNo}")
    private ResponseEntity<Object> getOtpByMemNo(@PathVariable String memNo){
        var member = otpService.getOtpByMemNo(memNo);
        if(member==null){
            Map<String,String> map= new HashMap<>();
            map.put("code","404");
            map.put("message","member number not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(member);
    }
   @PostMapping(path = "/registerOtp")
    public ResponseEntity<Otp> registerOtp(@RequestBody Otp otp){
        var token = otpService.addNewOtp(otp);
        return new ResponseEntity<>(token, HttpStatus.CREATED);
   }


}
