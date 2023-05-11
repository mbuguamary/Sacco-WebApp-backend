package com.sacco.saccoapp.instant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping(path="/api/v1/instant")
public class InstantController {
    private final InstantService instantService;
    @GetMapping
    public List<Instant> getInstant(){
        return instantService.getInstant();
    }
    @GetMapping("/{mem_no}")
    public Optional<Instant> getLoanById(@PathVariable String mem_no){
        return instantService.getLoanById(mem_no);
    }
    @PostMapping(path="/register")

    public void registerInstant (@RequestBody Instant instant){
        instantService.addNewInstant(instant);

    }

}
