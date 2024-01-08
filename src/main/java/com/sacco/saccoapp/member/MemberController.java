package com.sacco.saccoapp.member;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping(path="api/v1/member")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping
    public List <Member> getMember(){
        return memberService.getMember();
    }
    @PostMapping(path="/register")
    public void registerMember(@RequestBody Member member) {
     memberService.addNewMember(member);
    }




}
