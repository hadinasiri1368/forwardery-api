package com.forwardery.domain.authentication.repository;


import com.forwardery.domain.authentication.model.UserPermission;
import com.forwardery.repository.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersPermissionRepository extends BaseRepository<UserPermission, Long> {
    @Transactional
    @Modifying
    long deleteByUserId(Long userId);
}
