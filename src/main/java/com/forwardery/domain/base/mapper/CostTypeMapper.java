package com.forwardery.domain.base.mapper;

import com.forwardery.domain.base.dto.CostTypeDto;
import com.forwardery.domain.base.model.CostType;
import com.forwardery.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostTypeMapper extends BaseMapper<CostType, CostTypeDto> {
    @Override
    @Mapping(target = "id", source = "id")
    CostType toEntity(CostTypeDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    CostTypeDto toDto(CostType entity);
}
