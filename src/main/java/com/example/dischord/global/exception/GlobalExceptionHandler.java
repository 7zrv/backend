package com.example.dischord.global.exception;

import com.example.dischord.global.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ApiResponse<ExceptionResponse> handleBadRequestException(final BadRequestException e) {

        log.warn(e.getMessage(), e);

        return ApiResponse.error(e.getCode(), e.getMessage());
    }


    
    @ExceptionHandler(DuplicateException.class)
    public ApiResponse<ExceptionResponse> handleDuplicateException(final DuplicateException e) {

        log.warn(e.getMessage(), e);

        return ApiResponse.error(e.getCode(), e.getMessage());
    }


}
