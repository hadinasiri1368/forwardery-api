package com.forwardery.domain.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.dto.PermissionDto;
import com.forwardery.domain.mapper.PermissionMapper;
import com.forwardery.model.Permission;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/authentication/permission")
public class PermissionController extends BaseController<Permission, Long, PermissionDto> {
    public PermissionController(BaseService<Permission, Long> service, PermissionMapper mapper) {
        super(service, mapper);
    }
}
