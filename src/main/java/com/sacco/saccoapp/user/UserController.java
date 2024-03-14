package com.sacco.saccoapp.user;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/auth")
public class UserController {
  private final  UserService userService;
    @PutMapping(path= "/changePassword")
    public ResponseEntity<ApiResponse> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
      User user = userService.changePassword(changePasswordRequest);
      if(user!=null){
        return ResponseEntity.ok(new ApiResponse(200,"Password Changed Successful"));
      }
      return ResponseEntity.badRequest().body(new ApiResponse(400,"Error Occurred while changing the password"));
    }
}
