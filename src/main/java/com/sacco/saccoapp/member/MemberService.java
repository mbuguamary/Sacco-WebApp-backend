package com.sacco.saccoapp.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> getMember() {
      return  memberRepository.findAll();
    }
//    public List<Member> getMemberByNo(accNo) {
//        return  memberRepository.findBy(accNo);
//    }
    public void addNewMember(Member member) {
      memberRepository.save(member);
    }

    public Optional<Member> getMemberByMemNo(String accNo) {
        return memberRepository.findByAccNo(accNo);
    }
}
