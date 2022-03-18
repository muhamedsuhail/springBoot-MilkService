package com.demo.milkservice.web.controller;

import com.demo.milkservice.web.model.MilkDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MilkController.class)
class MilkControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getMilkById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/milk/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveNewMilk() throws Exception {
        MilkDTO milkDTO = MilkDTO.builder().build();
        String milkDTOJson = objectMapper.writeValueAsString(milkDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/milk/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(milkDTOJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateMilkById() throws Exception {
        MilkDTO milkDTO = MilkDTO.builder().build();
        String milkDTOJson = objectMapper.writeValueAsString(milkDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/milk/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(milkDTOJson))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}