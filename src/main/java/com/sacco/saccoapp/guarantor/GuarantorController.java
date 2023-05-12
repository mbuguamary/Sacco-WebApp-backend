package com.sacco.saccoapp.guarantor;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/guarantor")
@AllArgsConstructor
public class GuarantorController {
    private final GuarantorService guarantorService;
    @GetMapping
    public List<Guarantor> getGuarantors(){
        return guarantorService.getGuarantors();

    }

}
