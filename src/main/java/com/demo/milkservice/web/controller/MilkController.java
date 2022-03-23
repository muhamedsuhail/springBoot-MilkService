package com.demo.milkservice.web.controller;

import com.demo.milkservice.services.MilkService;
import com.demo.milkservice.web.model.MilkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/milk")
@RestController
public class MilkController {

    @Autowired
    MilkService milkService;

    @GetMapping("/{milkId}")
    public ResponseEntity<MilkDTO> getMilk(@PathVariable("milkId") UUID milkId) {
        // TODO impl
        return new ResponseEntity<>(milkService.getMilkById(milkId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewMilk(@RequestBody MilkDTO milkDTO) {
        // TODO impl
        MilkDTO saveDTO = milkService.saveNewMilk(milkDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/milk/" + saveDTO.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{milkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMilkById(@PathVariable("milkId") UUID milkId, MilkDTO milkDTO) {
        milkService.updateMilkById(milkId, milkDTO);
    }

    @DeleteMapping("/{milkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMilkById(@PathVariable("milkId") UUID milkId) {
        milkService.deleteMilkById(milkId);
    }
}
