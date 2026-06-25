package com.forwardery.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionDto {
    private String code;
    private String message;
    private String uuid;
    private String time;
}
