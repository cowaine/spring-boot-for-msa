package com.cowaine.corock.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
        log.error("Error Message: {}", ex.getErrorMessage());
        return new ResponseEntity<>(new ErrorResponse(ex.getErrorMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileDownloadException.class)
    public ResponseEntity handleFileDownloadException(FileDownloadException ex) {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return new ResponseEntity<>(new ErrorResponse("system error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
