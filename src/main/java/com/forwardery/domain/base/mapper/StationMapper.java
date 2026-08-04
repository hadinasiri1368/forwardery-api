package com.forwardery.domain.base.mapper;

import com.forwardery.domain.base.dto.StationDto;
import com.forwardery.domain.base.model.Station;
import com.forwardery.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StationMapper extends BaseMapper<Station, StationDto> {
    @Override
    @Mapping(target = "id", source = "id")
    Station toEntity(StationDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    StationDto toDto(Station entity);
}
