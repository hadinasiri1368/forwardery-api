package com.forwardery.domain.base.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RouteDto {
    private Long id;
    private Long sourceStation;
    private Long destinationStation;
    private Long distance;
    private String description;
}
