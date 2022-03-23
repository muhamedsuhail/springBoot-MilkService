package com.demo.milkservice.services;

import com.demo.milkservice.web.model.MilkDTO;
import com.demo.milkservice.web.model.MilkTypeEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MilkServiceImpl implements MilkService {

    @Override
    public MilkDTO getMilkById(UUID uuid) {
        MilkDTO milkDTO = MilkDTO.builder()
                .id(uuid)
                .version(1)
                .milkName("Aavin")
                .milkType(MilkTypeEnum.NICE)
                .build();
        return milkDTO;
    }

    @Override
    public MilkDTO saveNewMilk(MilkDTO milkDTO) {
        // TODO - Persistence
        return milkDTO;
    }

    @Override
    public void updateMilkById(UUID id, MilkDTO milkDTO) {
        // TODO - Persistence
    }

    @Override
    public void deleteMilkById(UUID id) {
        // TODO - Persistence
    }
}
