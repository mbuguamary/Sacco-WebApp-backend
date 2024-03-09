package com.sacco.saccoapp.dividend;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1/dividend")
@AllArgsConstructor
@RestController
public class DividendController {

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
