package com.forwardery.domain.authentication.model;

import com.forwardery.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "PERMISSION" ,schema = "SWALLET")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@SuperBuilder
public class Permission extends BaseEntity {
    @Column(columnDefinition = "NVARCHAR2(50)", name = "NAME", nullable = false)
    private String name;
    @Column(columnDefinition = "NVARCHAR2(300)", name = "URL", nullable = false)
    private String url;
    @Column(columnDefinition = "NUMBER(1)", name = "IS_SENSITIVE", nullable = false)
    private Boolean isSensitive;
}
