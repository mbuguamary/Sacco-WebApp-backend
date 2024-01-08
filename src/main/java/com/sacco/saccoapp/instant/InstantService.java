package com.sacco.saccoapp.instant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InstantService {
    private final InstantRepository instantRepository;
    public List<Instant> getInstant() {
      return instantRepository.findAll();
    }

    public Instant addNewInstant(Instant instant) {


        return instantRepository.save(instant);

    }


    public Optional<Instant> getLoanById(String memNo) {
      return  instantRepository.findByMemNo(memNo);
    }
}
