package com.forwardery.domain.base.mapper;

import com.forwardery.domain.base.dto.ServiceTypeDto;
import com.forwardery.domain.base.model.ServiceType;
import com.forwardery.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceTypeMapper extends BaseMapper<ServiceType, ServiceTypeDto> {
    @Override
    @Mapping(target = "id", source = "id")
    ServiceType toEntity(ServiceTypeDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    ServiceTypeDto toDto(ServiceType entity);
}
