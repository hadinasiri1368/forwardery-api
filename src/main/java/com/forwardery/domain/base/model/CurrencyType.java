package com.forwardery.domain.base.model;

import com.forwardery.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "currency_type", schema = "dbo")
public class CurrencyType extends BaseEntity {

    @Size(max = 50)
    @Nationalized
    @Column(name = "name", length = 50)
    private String name;

}