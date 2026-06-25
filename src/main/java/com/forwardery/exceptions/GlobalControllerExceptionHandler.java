package com.forwardery.exceptions;


import com.forwardery.config.security.RequestContext;
import com.forwardery.constants.DateFormat;
import com.forwardery.constants.TimeFormat;
import com.forwardery.log.impl.Log4jLogger;
import com.forwardery.util.AppUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerExceptionHandler {
    private final Log4jLogger log4jLogger;

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ExceptionDto> handleFundException(BaseException e, HttpServletRequest request) {
        String uuid = RequestContext.getUuid();
        String currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DateFormat.GREGORIAN.getValue() + " " + TimeFormat.HOUR_MINUTE_SECOND.getValue()));

        printLog(e.getStatus(), e.getMessage(), currentTime, uuid);
        return new ResponseEntity<>(ExceptionDto.builder()
                .code(e.getMessage())
                .message(AppUtils.getMessageFromMessageSource(e.getMessage(), e.getParams()))
                .uuid(uuid)
                .time(currentTime)
                .build(), e.getStatus());
    }

    @ExceptionHandler(value = DataAccessException.class)
    public ResponseEntity<ExceptionDto> handleDatabaseException(DataAccessException e, HttpServletRequest request) {
        String uuid = RequestContext.getUuid();
        String currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DateFormat.GREGORIAN.getValue() + " " + TimeFormat.HOUR_MINUTE_SECOND.getValue()));

        printLog(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), currentTime, uuid);

        return new ResponseEntity<>(ExceptionDto.builder()
                .code("database_exception.error")
                .message(AppUtils.getMessageFromMessageSource("database_exception.error"))
                .uuid(uuid)
                .time(currentTime)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionDto> handleGenralException(Exception e, HttpServletRequest request) {
        String uuid = RequestContext.getUuid();
        String currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DateFormat.GREGORIAN.getValue() + " " + TimeFormat.HOUR_MINUTE_SECOND.getValue()));

        printLog(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), currentTime, uuid);

        return new ResponseEntity<>(ExceptionDto.builder()
                .code("unhandled_exception.error")
                .message(AppUtils.getMessageFromMessageSource("unhandled_exception.error"))
                .uuid(uuid)
                .time(currentTime)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleGenralMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        String uuid = RequestContext.getUuid();
        String currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DateFormat.GREGORIAN.getValue() + " " + TimeFormat.HOUR_MINUTE_SECOND.getValue()));

        printLog(HttpStatus.BAD_REQUEST, e.getMessage(), currentTime, uuid);
        String message = errors.entrySet().iterator().next().getValue();
        String code = errors.entrySet().iterator().next().getValue().split("&")[0];
        Object[] params = getParams(message);
        return new ResponseEntity<>(ExceptionDto.builder()
                .code(code)
                .message(AppUtils.getMessageFromMessageSource(code, params))
                .uuid(uuid)
                .time(currentTime)
                .build(), HttpStatus.BAD_REQUEST);
    }

    private void printLog(HttpStatus httpStatus, String message, String currentTime, String uuid) {
        log4jLogger.exceptionLog(httpStatus, message, currentTime, uuid);
    }

    private Object[] getParams(String message) {
        if (message.split("&").length <= 1) {
            return null;
        }
        return !AppUtils.isNull(message.split("&")[1]) ? message.split("&")[1].split(",") : null;
    }

}

