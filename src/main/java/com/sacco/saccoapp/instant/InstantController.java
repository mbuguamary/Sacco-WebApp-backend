package com.sacco.saccoapp.instant;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="/api/v1/instant")
public class InstantController {
    private final InstantService instantService;
    @GetMapping
    public List<Instant> getInstant(){
        return instantService.getInstant();
    }
    @GetMapping("/{mem_no}")
    public ResponseEntity<Object> getLoanById(@PathVariable String mem_no){
        var loan= instantService.getLoanById(mem_no).orElse(null);

        if(loan==null){
            Map<String,String> map =new HashMap<>();
            map.put("code", "404");
            map.put("message", "Member number not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(loan);
    }
    @PostMapping(path="/register")
    public ResponseEntity<Instant> registerInstant (@RequestBody Instant instant){
        var loan = instantService.addNewInstant(instant);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

}
