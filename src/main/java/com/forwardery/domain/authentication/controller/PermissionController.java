package com.forwardery.domain.authentication.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.authentication.dto.PermissionDto;
import com.forwardery.domain.authentication.mapper.PermissionMapper;
import com.forwardery.domain.authentication.model.Permission;
import com.forwardery.domain.authentication.repository.PermissionRepository;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/authentication/permission")
public class PermissionController extends BaseController<Permission, Long, PermissionDto, PermissionRepository> {
    public PermissionController(BaseService<Permission, Long, PermissionRepository> service, PermissionMapper mapper) {
        super(service, mapper);
    }
}
