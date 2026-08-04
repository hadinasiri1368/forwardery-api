package com.forwardery.domain.base.mapper;

import com.forwardery.domain.base.dto.RouteDto;
import com.forwardery.domain.base.model.Route;
import com.forwardery.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RouteMapper extends BaseMapper<Route, RouteDto> {
    @Override
    @Mapping(target = "id", source = "id")
    Route toEntity(RouteDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    RouteDto toDto(Route entity);
}
