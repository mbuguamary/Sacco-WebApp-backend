package com.sacco.saccoapp.guarantor;

import com.sacco.saccoapp.dividend.Dividend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GuarantorRepository extends JpaRepository<Guarantor,Long> {

    @Query("SELECT s from Guarantor s where s.id =?1")
    Optional<Guarantor> findById(Long id);

}
