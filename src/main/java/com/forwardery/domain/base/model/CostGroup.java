package com.forwardery.domain.base.model;

import com.forwardery.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "cost_group", schema = "dbo")
public class CostGroup extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "name", nullable = false, length = 50)
    private String name;

}