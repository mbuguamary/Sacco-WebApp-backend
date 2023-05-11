package com.sacco.saccoapp.instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InstantRepository extends JpaRepository<Instant,Long> {
    @Query("SELECT s from Instant s where s.id =?1")
    Optional<Instant> findById(Long id);

    @Query("SELECT s from Instant s where s.mem_no =?1")
    Optional<Instant> findByMemNo(String mem_no);
}
