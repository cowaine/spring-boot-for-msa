package com.cowaine.corock.chapter05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class ErrorResponse {

    private final String errorMessage;

}
