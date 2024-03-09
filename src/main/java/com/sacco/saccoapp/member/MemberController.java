package com.sacco.saccoapp.member;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(path="/api/v1/member")
@AllArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;
    @GetMapping
    public List <Member> getMember(){
        return memberService.getMember();
  }
   @GetMapping(path="/{accNo}")
    public ResponseEntity<Object> getMemberByMemNo(@PathVariable String accNo){
        var member = memberService.getMemberByMemNo(accNo);
        if(member==null){
            Map<String,String> map= new HashMap<>();
            map.put("code","404");
            map.put("message","member number not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(member);
    }

    @PostMapping(path="/register")
    public void registerMember(@RequestBody Member member) {
     memberService.addNewMember(member);
    }




}
