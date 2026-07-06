package com.forwardery.domain.base.model;

import com.forwardery.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cargo_type", schema = "dbo")
public class CargoType extends BaseEntity  {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

}