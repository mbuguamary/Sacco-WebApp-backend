package com.sacco.saccoapp.instant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstantService {
    private final InstantRepository instantRepository;
    public List<Instant> getInstant() {
      return instantRepository.findAll();
    }

    public void addNewInstant(Instant instant) {
        instantRepository.save(instant);
    }
}
