package com.cowaine.corock.chapter05;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private final String errorMessage;

    public BadRequestException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

}
