package com.forwardery.config.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forwardery.constants.DateFormat;
import com.forwardery.constants.TimeFormat;
import com.forwardery.domain.authentication.service.AuthenticationService;
import com.forwardery.exceptions.BaseException;
import com.forwardery.exceptions.ExceptionDto;
import com.forwardery.log.impl.Log4jLogger;
import com.forwardery.util.AppUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@RequiredArgsConstructor
public class Logout implements LogoutHandler {
    private final AuthenticationService service;
    private final Log4jLogger log4jLogger;


    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            String token = AppUtils.getToken(request);
            service.logout(token);
        } catch (BaseException e) {
            handleException(response, e.getMessage(), e.getParams());
        } catch (Exception e) {
            handleException(response, "general_exception.Unknown_error", null);
        } finally {
            RequestContext.clear();
        }
    }

    private void handleException(HttpServletResponse response, String message, Object[] params) {
        String currentTime = getCurrentTime();
        String uuid = RequestContext.getUuid();

        log4jLogger.exceptionLog(HttpStatus.UNAUTHORIZED, message, currentTime, uuid);

        try {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(convertObjectToJson(ExceptionDto.builder()
                    .code(message)
                    .message(AppUtils.getMessageFromMessageSource(message, params))
                    .uuid(uuid)
                    .time(currentTime)
                    .build()));
        } catch (Exception ex) {
            log4jLogger.exceptionLog(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), currentTime, uuid);
        }
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                DateFormat.GREGORIAN.getValue() + " " + TimeFormat.HOUR_MINUTE_SECOND.getValue()));
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        return object == null ? null : new ObjectMapper().writeValueAsString(object);
    }
}
