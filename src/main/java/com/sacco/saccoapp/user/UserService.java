package com.sacco.saccoapp.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void changePassword(String memberNo,  String password) {
        User user= userRepository.findByMemberNo(memberNo).orElseThrow(()-> new IllegalStateException("\"Member with member No \"+memberNo+\" does not exists\""));


        user.setPassword(passwordEncoder.encode(password));


    }

}
