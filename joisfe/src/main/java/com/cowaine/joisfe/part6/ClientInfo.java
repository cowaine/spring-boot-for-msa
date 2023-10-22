package com.cowaine.joisfe.part6;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class ClientInfo {

    private final String channel;
    private final String clientAddress;
}