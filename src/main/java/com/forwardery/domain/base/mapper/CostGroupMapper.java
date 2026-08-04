package com.forwardery.domain.base.mapper;

import com.forwardery.domain.base.dto.CostGroupDto;
import com.forwardery.domain.base.model.CostGroup;
import com.forwardery.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostGroupMapper extends BaseMapper<CostGroup, CostGroupDto> {
    @Override
    @Mapping(target = "id", source = "id")
    CostGroup toEntity(CostGroupDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    CostGroupDto toDto(CostGroup entity);
}
