package com.forwardery.domain.authentication.model;

import com.forwardery.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "USER_PERMISSION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserPermission extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "F_USER_ID")
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "F_PERMISSION_ID")
    private Permission permission;
}
