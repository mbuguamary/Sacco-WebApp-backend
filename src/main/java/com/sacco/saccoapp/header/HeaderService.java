package com.sacco.saccoapp.header;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HeaderService {
    private final HeaderRepository headerRepository
    public List<Header> getHeader() {
     return headerRepository.findAll();
    }


    public void addNewHeader(Header header) {
        headerRepository.save(header);
    }
}
