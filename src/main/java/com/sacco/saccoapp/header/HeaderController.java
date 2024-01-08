package com.sacco.saccoapp.header;

import com.sacco.saccoapp.instant.InstantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/header")
@RequiredArgsConstructor
public class HeaderController {
    private final HeaderService headerService;
    @GetMapping
    public List<Header> getHeader(){
        return headerService.getHeader();
    }

    @PostMapping(path = "/register")
    public void addHeader(@RequestBody Header header){
        headerService.addNewHeader(header);
    }
}
