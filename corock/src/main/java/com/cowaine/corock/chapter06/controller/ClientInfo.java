package com.cowaine.corock.chapter06.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class ClientInfo {

    private final String channel;
    private final String clientAddress;

}
