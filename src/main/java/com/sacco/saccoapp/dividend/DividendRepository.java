package com.sacco.saccoapp.dividend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DividendRepository extends JpaRepository<Dividend,Long> {
    @Query("SELECT s from Dividend s where s.id =?1")
    Optional<Dividend> findById(Long id);
}
