package com.forwardery.domain.base.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CostTypeDto {
    private Long id;
    private String name;
    private Long costGroup;
    private Boolean isOfficial;
}
