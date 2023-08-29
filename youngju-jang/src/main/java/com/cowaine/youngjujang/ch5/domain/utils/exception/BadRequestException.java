package com.cowaine.youngjujang.ch5.domain.utils.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException{
     private String errorMessage;
     
     public BadRequestException(String errorMessage) {
          super();
          this.errorMessage = errorMessage;
     }
}
