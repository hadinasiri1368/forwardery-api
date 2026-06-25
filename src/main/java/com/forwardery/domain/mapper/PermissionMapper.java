package com.forwardery.domain.mapper;

import com.forwardery.domain.dto.PermissionDto;
import com.forwardery.mapper.BaseMapper;
import com.forwardery.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<Permission, PermissionDto> {
    @Override
    @Mapping(target = "id", source = "id")
    Permission toEntity(PermissionDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    PermissionDto toDto(Permission entity);
}
