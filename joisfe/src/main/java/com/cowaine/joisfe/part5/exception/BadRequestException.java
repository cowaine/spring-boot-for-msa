package com.cowaine.joisfe.part5.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private String errorMessage;

    public BadRequestException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }
}
