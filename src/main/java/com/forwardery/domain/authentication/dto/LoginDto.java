package com.forwardery.domain.authentication.dto;

import com.forwardery.domain.authentication.model.Users;
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
