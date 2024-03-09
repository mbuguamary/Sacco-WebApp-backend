package com.sacco.saccoapp.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query("SELECT s from Member s where s.id =?1")
    Optional<Member> findById(Long id);
    @Query("SELECT s from Member s where s.accNo =?1")
    Optional<Member> findByAccNo(String accNo);
}
