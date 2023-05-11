package com.sacco.saccoapp.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> getMember() {
      return  memberRepository.findAll();
    }

    public void addNewMember(Member member) {
      memberRepository.save(member);
    }
}
