package com.forwardery.domain.controller;

import com.forwardery.constants.Consts;
import com.forwardery.domain.dto.LoginDto;
import com.forwardery.domain.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping(path = "/login")
    public String login(@RequestBody LoginDto loginDto) throws Exception {
        return service.login(loginDto);
    }

    @PutMapping(path = Consts.DEFAULT_PREFIX_API_URL + "/refreshToken")
    public String refreshToken() throws Exception {
        return service.refreshToken();
    }
}
