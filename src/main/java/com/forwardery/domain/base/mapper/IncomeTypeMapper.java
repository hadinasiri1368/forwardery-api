package com.forwardery.domain.base.mapper;

import com.forwardery.domain.base.dto.IncomeTypeDto;
import com.forwardery.domain.base.model.IncomeType;
import com.forwardery.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IncomeTypeMapper extends BaseMapper<IncomeType, IncomeTypeDto> {
    @Override
    @Mapping(target = "id", source = "id")
    IncomeType toEntity(IncomeTypeDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    IncomeTypeDto toDto(IncomeType entity);
}
