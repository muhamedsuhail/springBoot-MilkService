package com.demo.milkservice.services;

import com.demo.milkservice.web.model.MilkDTO;

import java.util.UUID;

public interface MilkService {
    public MilkDTO getMilkById(UUID uuid);
    public MilkDTO saveNewMilk(MilkDTO milkDTO);
    public void updateMilkById(UUID id, MilkDTO milkDTO);
    public void deleteMilkById(UUID id);
}
