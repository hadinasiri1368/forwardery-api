package com.forwardery.domain.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AssignPermissionsToUser {
    private Long userId;
    private List<Long> permissionIds;
}
