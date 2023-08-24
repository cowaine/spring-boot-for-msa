package com.cowaine.corock.chapter03.di;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class OrderProduct {

    private final LocalDateTime orderAt;

}
