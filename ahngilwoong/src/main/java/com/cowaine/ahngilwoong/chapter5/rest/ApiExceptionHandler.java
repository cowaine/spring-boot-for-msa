package com.cowaine.ahngilwoong.chapter5.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(FileDownloadException.class)
    public ResponseEntity handleFileDownloadException(FileDownloadException e) {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
