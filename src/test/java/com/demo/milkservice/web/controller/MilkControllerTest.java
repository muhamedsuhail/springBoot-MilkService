package com.demo.milkservice.web.controller;

import com.demo.milkservice.bootstrap.MilkLoader;
import com.demo.milkservice.domain.Milk;
import com.demo.milkservice.services.MilkService;
import com.demo.milkservice.web.model.MilkTypeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.UUID;
import com.demo.milkservice.web.model.MilkDTO;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@WebMvcTest(MilkController.class)
public class MilkControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MilkService milkService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getMilkById() throws Exception {

        given(milkService.getMilkById(any())).willReturn(getValidMilkDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/milk/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveNewMilk() throws Exception {

        MilkDTO milkDTO = getValidMilkDTO();
        String milkDTOJson = objectMapper.writeValueAsString(milkDTO);

        given(milkService.saveNewMilk(any())).willReturn(getValidMilkDTO());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/milk/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(milkDTOJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateMilkById() throws Exception {

        MilkDTO milkDTO = getValidMilkDTO();
        String milkDTOJson = objectMapper.writeValueAsString(milkDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/milk/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(milkDTOJson))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        then(milkService).should().updateMilkById(any(),any());
    }

    MilkDTO getValidMilkDTO() {
        return MilkDTO.builder()
                .id(UUID.randomUUID())
                .milkName("Aavin")
                .milkType(MilkTypeEnum.NICE)
                .price(new BigDecimal("25.50"))
                .upc(MilkLoader.MILK_1_UPC)
                .build();
    }
}