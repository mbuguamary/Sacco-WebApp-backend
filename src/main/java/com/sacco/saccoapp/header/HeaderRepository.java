package com.sacco.saccoapp.header;

import com.sacco.saccoapp.dividend.Dividend;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeaderRepository extends JpaRepository<Header,Long> {
    @Query("SELECT s.header_name s from Header s where s.id =?1")
    Optional<Tuple> findByHeaderId(Long id);
}
