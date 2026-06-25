package com.forwardery.config.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forwardery.constants.DateFormat;
import com.forwardery.constants.TimeFormat;
import com.forwardery.exceptions.BaseException;
import com.forwardery.exceptions.ExceptionDto;
import com.forwardery.log.impl.Log4jLogger;
import com.forwardery.util.AppUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private final Log4jLogger log4jLogger;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException {
        HttpStatus status = HttpStatus.FORBIDDEN;
        Object[] params = null;

        if (e.getCause() instanceof BaseException fe) {
            status = fe.getStatus();
            params = ((BaseException) fe).getParams();
        }

        String currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DateFormat.GREGORIAN.getValue() + " " + TimeFormat.HOUR_MINUTE_SECOND.getValue()));
        log4jLogger.exceptionLog(status, e.getMessage(), currentTime, RequestContext.getUuid());

        response.setStatus(status.value());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(convertObjectToJson(ExceptionDto.builder()
                .code(e.getMessage())
                .message(AppUtils.getMessageFromMessageSource(e.getMessage(), params))
                .uuid(RequestContext.getUuid())
                .time(currentTime)
                .build()));
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
