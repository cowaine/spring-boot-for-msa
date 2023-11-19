package com.cowaine.corock.chapter09.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCodeRequest {

    private Integer type;

    @JsonProperty("hotelIds")
    private List<Long> ids;

}
