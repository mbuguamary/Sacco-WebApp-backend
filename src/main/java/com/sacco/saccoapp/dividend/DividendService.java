package com.sacco.saccoapp.dividend;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DividendService {
    private final DividendRepository dividendRepository;
    public List<Dividend> getDividends() {
        return dividendRepository.findAll();
    }

    public void addNewDividend(Dividend dividend) {
        dividendRepository.save(dividend);
    }
}
