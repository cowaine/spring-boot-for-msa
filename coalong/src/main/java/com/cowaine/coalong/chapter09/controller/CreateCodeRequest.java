package com.cowaine.coalong.chapter09.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CreateCodeRequest {
    private Integer type;

    @JsonProperty("hotelIds")
    private List<Long> ids;

    public CreateCodeRequest() {
    }

    public CreateCodeRequest(Integer type, List<Long> ids) {
        this.type = type;
        this.ids = ids;
    }
}
