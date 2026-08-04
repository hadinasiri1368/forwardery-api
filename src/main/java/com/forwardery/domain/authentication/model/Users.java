package com.forwardery.domain.authentication.model;


import com.forwardery.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@Table(name = "USERS" ,schema = "SWALLET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users extends BaseEntity {
    public Users(Long id) {
        this.id = id;
    }

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "FAMILY", nullable = false, length = 50)
    private String family;
    @Column(name = "IS_ACTIVE", columnDefinition = "NUMBER(1)", nullable = false)
    private Boolean isActive;
    @Column(name = "IS_ADMIN", columnDefinition = "NUMBER(1)", nullable = false)
    private Boolean isAdmin;
    @Column(name = "USERNAME", columnDefinition = "NVARCHAR2(50)", nullable = false, unique = true)
    private String username;
    @Column(name = "PASSWORD", columnDefinition = "NVARCHAR2(200)", nullable = false)
    private String password;

}
