package com.cowaine.youngjujang.ch5.domain.utils.exception;

import com.cowaine.youngjujang.ch5.domain.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // @ControllerAdvice + @ResponseEntity
public class ApiExceptionHandler {
     @ExceptionHandler(BadRequestException.class)
     public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex){
          System.out.println("Error Message : " + ex.getErrorMessage());
          return new ResponseEntity<>(
               new ErrorResponse(ex.getErrorMessage()),
               HttpStatus.BAD_REQUEST
          );
     }
     
     @ExceptionHandler(FileDownloadException.class)
     public ResponseEntity handleFileDownloadException(FileDownloadException e){
          return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
     }
     
     @ExceptionHandler(Exception.class)
     public ResponseEntity<ErrorResponse> handleException(Exception ex){
          return new ResponseEntity<>(
               new ErrorResponse("system error"),
               HttpStatus.INTERNAL_SERVER_ERROR
          );
     }
}
