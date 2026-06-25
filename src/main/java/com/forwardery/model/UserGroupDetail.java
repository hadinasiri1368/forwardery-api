package com.forwardery.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Table(name = "USER_GROUP_DETAIL")
@Entity(name = "userGroupDetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupDetail extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "F_USER_ID")
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "F_USER_GROUP_ID")
    private UserGroup userGroup;
}
