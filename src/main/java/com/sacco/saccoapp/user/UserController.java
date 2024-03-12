package com.sacco.saccoapp.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/auth")
public class UserController {
  private final  UserService userService;
    @PutMapping(path= "/changePassword/{memberNo}")
    public void changePassword(
            @PathVariable("memberNo")  String memberNo,
            @PathVariable(required = false) String password
    ){
        userService.changePassword(memberNo,password);
    }
}
