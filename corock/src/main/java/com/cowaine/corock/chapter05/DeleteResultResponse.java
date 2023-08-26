package com.cowaine.corock.chapter05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DeleteResultResponse {

    private final boolean success;
    private final String message;

}
