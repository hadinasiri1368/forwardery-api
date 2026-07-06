package com.forwardery.domain.authentication.model;

import com.forwardery.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Role_PERMISSION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RolePermission extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "F_ROLE_ID")
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "F_PERMISSION_ID")
    private Permission permission;
}
