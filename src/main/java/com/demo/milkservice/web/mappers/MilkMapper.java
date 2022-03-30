package com.demo.milkservice.web.mappers;

import com.demo.milkservice.domain.Milk;
import com.demo.milkservice.web.model.MilkDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface MilkMapper {

    MilkDTO milkToMilkDTO(Milk milk);

    Milk milkDTOToMilk(MilkDTO milkDTO);
}
