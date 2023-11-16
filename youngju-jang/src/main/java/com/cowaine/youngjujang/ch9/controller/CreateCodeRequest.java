package com.cowaine.youngjujang.ch9.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCodeRequest {

     private Integer type;
     
     @JsonProperty ("hotelIds")
     private List<Long> ids;

}
