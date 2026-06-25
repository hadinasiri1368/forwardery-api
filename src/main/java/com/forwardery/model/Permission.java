package com.forwardery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Table(name = "PERMISSION" ,schema = "SWALLET")
@Entity(name = "permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
public class Permission extends BaseEntity {
    @Column(columnDefinition = "NVARCHAR2(50)", name = "NAME", nullable = false)
    private String name;
    @Column(columnDefinition = "NVARCHAR2(300)", name = "URL", nullable = false)
    private String url;
    @Column(columnDefinition = "NUMBER(1)", name = "IS_SENSITIVE", nullable = false)
    private Boolean isSensitive;
}
