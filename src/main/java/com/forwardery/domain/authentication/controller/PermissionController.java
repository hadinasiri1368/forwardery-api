package com.forwardery.domain.authentication.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.authentication.dto.AssignPermissionsToUser;
import com.forwardery.domain.authentication.dto.PermissionDto;
import com.forwardery.domain.authentication.mapper.PermissionMapper;
import com.forwardery.domain.authentication.model.Permission;
import com.forwardery.domain.authentication.repository.PermissionRepository;
import com.forwardery.domain.authentication.service.PermissionService;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/authentication/permission")
public class PermissionController extends BaseController<Permission, Long, PermissionDto, PermissionRepository> {
    private final PermissionService permissionService;

    public PermissionController(BaseService<Permission, Long, PermissionRepository> service,
                                PermissionMapper mapper,
                                PermissionService permissionService) {
        super(service, mapper);
        this.permissionService = permissionService;
    }

    @PostMapping("/assignPermissionsToUser")
    public void assignPermissionsToUser(@RequestBody AssignPermissionsToUser request) {
        permissionService.assignPermissionsToUser(request.getUserId(), request.getPermissionIds());
    }
}
