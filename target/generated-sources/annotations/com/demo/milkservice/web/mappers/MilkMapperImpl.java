package com.demo.milkservice.web.mappers;

import com.demo.milkservice.domain.Milk;
import com.demo.milkservice.domain.Milk.MilkBuilder;
import com.demo.milkservice.web.model.MilkDTO;
import com.demo.milkservice.web.model.MilkDTO.MilkDTOBuilder;
import com.demo.milkservice.web.model.MilkTypeEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-30T23:38:30+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class MilkMapperImpl implements MilkMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public MilkDTO milkToMilkDTO(Milk milk) {
        if ( milk == null ) {
            return null;
        }

        MilkDTOBuilder milkDTO = MilkDTO.builder();

        milkDTO.id( milk.getId() );
        milkDTO.version( (int) milk.getVersion() );
        milkDTO.createdDate( dateMapper.asOffsetDateTime( milk.getCreatedDate() ) );
        milkDTO.modifiedDate( dateMapper.asOffsetDateTime( milk.getModifiedDate() ) );
        milkDTO.milkName( milk.getMilkName() );
        if ( milk.getMilkType() != null ) {
            milkDTO.milkType( Enum.valueOf( MilkTypeEnum.class, milk.getMilkType() ) );
        }
        milkDTO.upc( milk.getUpc() );
        milkDTO.price( milk.getPrice() );

        return milkDTO.build();
    }

    @Override
    public Milk milkDTOToMilk(MilkDTO milkDTO) {
        if ( milkDTO == null ) {
            return null;
        }

        MilkBuilder milk = Milk.builder();

        milk.id( milkDTO.getId() );
        if ( milkDTO.getVersion() != null ) {
            milk.version( milkDTO.getVersion() );
        }
        milk.createdDate( dateMapper.asTimestamp( milkDTO.getCreatedDate() ) );
        milk.modifiedDate( dateMapper.asTimestamp( milkDTO.getModifiedDate() ) );
        milk.milkName( milkDTO.getMilkName() );
        if ( milkDTO.getMilkType() != null ) {
            milk.milkType( milkDTO.getMilkType().name() );
        }
        milk.upc( milkDTO.getUpc() );
        milk.price( milkDTO.getPrice() );

        return milk.build();
    }
}
