package com.forwardery.domain.repository;


import com.forwardery.domain.dto.UserPermissionDto;
import com.forwardery.model.Permission;
import com.forwardery.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long> {
    @Query("""
                select p,up.user.id as userId from userPermission up
                    inner join permission p on p.id=up.permission.id
            """)
    List<UserPermissionDto> findAllPermissionFromUser();

    @Query("""
                select new com.forwardery.domain.dto.UserPermissionDto(p,ur.user.id) from userRole ur
                    inner join rolePermission rp on rp.role.id=ur.role.id
                    inner join permission p on p.id=rp.permission.id
            """)
    List<UserPermissionDto> findAllPermissionFromRole();

}
