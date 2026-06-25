package com.forwardery.domain.dto;

import com.forwardery.model.Users;
import com.forwardery.validator.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDto {
    @ValidateField(fieldName = "username", entityClass = Users.class)
    private String username;
    @NotEmpty(fieldName = "password")
    private String password;
}
