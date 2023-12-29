package com.cowaine.corock.chapter09.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private boolean success;
    private String resultMessage;
    private T data;

}
