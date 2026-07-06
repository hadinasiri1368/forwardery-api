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
@Table(name = "route", schema = "dbo")
public class Route extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "f_source_station_id", nullable = false)
    private Station fSourceStation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "f_destination_station_id", nullable = false)
    private Station fDestinationStation;

    @NotNull
    @Column(name = "distance", nullable = false)
    private Long distance;

    @Size(max = 500)
    @Nationalized
    @Column(name = "description", length = 500)
    private String description;

}