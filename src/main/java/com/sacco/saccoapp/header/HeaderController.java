package com.sacco.saccoapp.header;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = "/api/v1/header")
@AllArgsConstructor
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
