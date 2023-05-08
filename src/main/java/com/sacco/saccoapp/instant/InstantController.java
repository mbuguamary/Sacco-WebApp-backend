package com.sacco.saccoapp.instant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@RequestMapping(path="/api/v1/instant")
public class InstantController {
    private final InstantService instantService;
    @GetMapping
    public List<Instant> getInstant(){
        return instantService.getInstant();
    }
    @PostMapping(path="/register")

    public void registerInstant (@RequestBody Instant instant){
        instantService.addNewInstant(instant);

    }

}
