package com.cowaine.dingcook.chapter05.domain.hotelroom.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DeleteResultResponse {

    private final boolean isSuccess;
    private final String message;
}
