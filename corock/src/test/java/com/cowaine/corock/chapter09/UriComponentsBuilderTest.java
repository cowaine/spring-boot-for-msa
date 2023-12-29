package com.cowaine.corock.chapter09;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UriComponentsBuilderTest {

    @DisplayName("testBuild")
    @Test
    public void testBuild() {
        URI uri = UriComponentsBuilder.fromPath("/hotel-names/{hotelName}")
                .queryParam("type", "{type}")
                .queryParam("isActive", "{isActive}")
                .scheme("https").host("127.0.0.1").port(20420)
                .build("LineHotel", "Hotel", "true");

        assertEquals("https://127.0.0.1:20420/hotel-names/LineHotel?type=Hotel&isActive=true", uri.toString());
    }

    @DisplayName("testEncoding")
    @Test
    public void testEncoding() {
        URI firstUri = UriComponentsBuilder.fromPath("/hotel-names/{hotelName}")
                .scheme("https").host("127.0.0.1").port(20420)
                .build("한국호텔");

        assertEquals("https://127.0.0.1:20420/hotel-names/%ED%95%9C%EA%B5%AD%ED%98%B8%ED%85%94",
                firstUri.toString());

        String variable = "한국호텔";
        String path = "/hotel-names/" + variable;
        URI secondUri = UriComponentsBuilder.fromPath(path)
                .scheme("https").host("127.0.0.1").port(20420)
                .build()
                .toUri();

        assertEquals("https://127.0.0.1:20420/hotel-names/한국호텔", secondUri.toString());

        URI thirdUri = UriComponentsBuilder.fromPath(path)
                .scheme("https").host("127.0.0.1").port(20420)
                .build(false)
                .encode()
                .toUri();

        assertEquals("https://127.0.0.1:20420/hotel-names/%ED%95%9C%EA%B5%AD%ED%98%B8%ED%85%94",
                thirdUri.toString());
    }

}
