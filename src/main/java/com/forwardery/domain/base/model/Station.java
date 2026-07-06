package com.forwardery.domain.base.model;

import com.forwardery.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "station", schema = "dbo")
public class Station extends BaseEntity {

    @Size(max = 50)
    @Nationalized
    @Column(name = "name", length = 50)
    private String name;

}