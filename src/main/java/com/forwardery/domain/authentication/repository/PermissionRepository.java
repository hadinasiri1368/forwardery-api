package com.forwardery.domain.authentication.repository;


import com.forwardery.domain.authentication.dto.UserPermissionDto;
import com.forwardery.domain.authentication.model.Permission;
import com.forwardery.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long> {
    @Query("""
                select p,up.user.id as userId from UserPermission up
                    inner join Permission p on p.id=up.permission.id
            """)
    List<UserPermissionDto> findAllPermissionFromUser();

    @Query("""
                select new com.forwardery.domain.authentication.dto.UserPermissionDto(p,ur.user.id) from UserRole ur
                    inner join RolePermission rp on rp.role.id=ur.role.id
                    inner join Permission  p on p.id=rp.permission.id
            """)
    List<UserPermissionDto> findAllPermissionFromRole();

}
