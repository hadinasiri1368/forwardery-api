package com.forwardery.domain.mapper;

import com.forwardery.domain.dto.PermissionDto;
import com.forwardery.mapper.BaseMapper;
import com.forwardery.model.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<Permission, PermissionDto> {
}
