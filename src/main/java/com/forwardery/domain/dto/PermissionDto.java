package com.forwardery.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PermissionDto {
    private Long id;
    private String name;
    private String url;
    private Boolean isSensitive;
}

