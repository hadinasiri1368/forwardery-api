package com.forwardery.domain.authentication.service;

import com.forwardery.domain.authentication.dto.UserPermissionDto;
import com.forwardery.domain.authentication.model.UserPermission;
import com.forwardery.domain.authentication.repository.PermissionRepository;
import com.forwardery.domain.authentication.model.Permission;
import com.forwardery.domain.authentication.model.Users;
import com.forwardery.domain.authentication.repository.UsersPermissionRepository;
import com.forwardery.service.BaseService;
import com.forwardery.util.AppUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PermissionService extends BaseService<Permission, Long, PermissionRepository> {
    @Value("${authentication.paths-to-bypass}")
    private List<String> pathsToBypass;
    private static final AntPathMatcher pathMatcher = new AntPathMatcher();
    private final UsersPermissionRepository usersPermissionRepository;

    public PermissionService(PermissionRepository repository,
                             UsersPermissionRepository usersPermissionRepository) {
        super(repository, Permission.class);
        this.usersPermissionRepository = usersPermissionRepository;
    }

    public boolean isAuthenticationRequired(HttpServletRequest request) {
        if (request.getMethod().equals("OPTIONS")) {
            return false;
        }

        if (isBypassedUrl(request.getRequestURI())) {
            return false;
        }

        Permission permission = findPermissionByUrl(request.getRequestURI());
        if (permission == null) {
            return true;
        }
        return permission.getIsSensitive();
    }

    public Permission findPermissionByUrl(String requestUrl) {
        return repository.findAll().stream()
                .filter(a -> a.getIsSensitive() && AppUtils.removeNumericPathVariables(requestUrl).toLowerCase().startsWith(a.getUrl().toLowerCase()))
                .findFirst()
                .orElse(null);
    }


    public Set<Permission> getPermissions(Users user) {
        if (user.getIsAdmin()) {
            return new HashSet<>(findAll());
        }

        return getUserPermissions(user.getId()).stream().collect(Collectors.toSet());
    }

    public boolean isBypassedUrl(String requestUrl) {
        for (String path : pathsToBypass) {
            if (pathMatcher.match(path.trim(), requestUrl)) {
                return true;
            }
        }
        return false;
    }

    private List<Permission> getUserPermissions(Long userId) {
        List<UserPermissionDto> userPermissionDtos = repository.findAllPermissionFromUser();
        userPermissionDtos.addAll(repository.findAllPermissionFromRole());


        List<Permission> permissions = userPermissionDtos.stream()
                .filter(a -> a.getUserId().equals(userId))
                .map(UserPermissionDto::getPermission)
                .collect(Collectors.toList());
        return permissions;
    }

    public void assignPermissionsToUser(Long userId, List<Long> permissionIds) {
        List<UserPermission> list = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            list.add(new UserPermission(new Users(userId), new Permission(permissionId)));
        }
        usersPermissionRepository.saveAll(list);
    }
}
