package com.cowaine.youngjujang.ch5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
     private String message;
     
     public static ErrorResponse of(String message){
          return new ErrorResponse(message);
     }
}
