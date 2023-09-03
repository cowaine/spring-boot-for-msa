package com.cowaine.youngjujang.ch5.domain.utils.exception;

import lombok.Getter;

@Getter
public class FileDownloadException extends RuntimeException{
     private String errorMessage;
     
     public FileDownloadException(String errorMessage) {
          super();
          this.errorMessage = errorMessage;
     }
}
