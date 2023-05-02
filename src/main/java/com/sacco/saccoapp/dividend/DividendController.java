package com.sacco.saccoapp.dividend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/dividend")
public class DividendController {
@PostMapping
private final DividendService dividendService;

    @GetMapping
    public List<Dividend> getDividends(){
        return dividendService.getDividends();
    }
    @PostMapping(path="/register")
    public void registerNewDividend(@RequestBody Dividend dividend){
        dividendService.addNewDividend(dividend);
    }

}
