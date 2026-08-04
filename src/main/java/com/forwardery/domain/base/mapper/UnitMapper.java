package com.forwardery.domain.base.mapper;

import com.forwardery.domain.base.dto.UnitDto;
import com.forwardery.domain.base.model.Unit;
import com.forwardery.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UnitMapper extends BaseMapper<Unit, UnitDto> {
    @Override
    @Mapping(target = "id", source = "id")
    Unit toEntity(UnitDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    UnitDto toDto(Unit entity);
}
