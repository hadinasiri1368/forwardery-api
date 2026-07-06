package com.forwardery.domain.base.mapper;

import com.forwardery.domain.base.dto.CargoTypeDto;
import com.forwardery.domain.base.dto.CurrencyTypeDto;
import com.forwardery.domain.base.model.CargoType;
import com.forwardery.domain.base.model.CurrencyType;
import com.forwardery.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurrencyTypeMapper extends BaseMapper<CurrencyType,CurrencyTypeDto> {

    @Override
    @Mapping(target = "id", source = "id")
    CurrencyType toEntity(CurrencyTypeDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    CurrencyTypeDto toDto(CurrencyType entity);
}
