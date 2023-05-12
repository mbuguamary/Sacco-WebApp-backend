package com.sacco.saccoapp.guarantor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/guarantor")
public class GuarantorController {
    @GetMapping
    public List<Guarantor> getGuarantors(){
        return guarantorService.getGuarantors;

    }

}
