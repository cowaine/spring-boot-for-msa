package com.cowaine.youngjujang.ch6.domain.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ClientInfo {
     private final String channel;
     private final String clientAddress;
}
