package com.sacco.saccoapp.guarantor;

import com.sacco.saccoapp.dividend.Dividend;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GuarantorService {
    private final GuarantorRepository guarantorRepository;

    public List<Guarantor> getGuarantors() {
     return   guarantorRepository.findAll();
    }
}