package com.sacco.saccoapp.otp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp,Long> {

    @Query("Select s from Otp s where s.id=?1")
    Optional<Otp> findById(Long id);

    @Query("Select s from Otp s where s.memNo=?1 and s.keyUsed=false")
    Optional<Otp> findByMemNo(String  memNo);

}
