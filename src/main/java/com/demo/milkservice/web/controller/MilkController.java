package com.demo.milkservice.web.controller;

import com.demo.milkservice.web.model.MilkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/milk")
@RestController
public class MilkController {

    @GetMapping("/{milkId}")
    public ResponseEntity<MilkDTO> getMilkById(@PathVariable("milkId") UUID milkId){
        // TODO impl
        return new ResponseEntity<>(MilkDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewMilk(@RequestBody MilkDTO milkDTO){
        // TODO impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{milkId}")
    public ResponseEntity updateMilkById(@PathVariable("milkId") UUID milkId){
        // TODO impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
