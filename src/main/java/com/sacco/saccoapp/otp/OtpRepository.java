package com.sacco.saccoapp.otp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp,Integer> {

    @Query("Select s from Otp s where s.id=?1")
    Optional<Otp> findById(Integer id);

}
