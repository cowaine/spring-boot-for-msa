package com.cowaine.joisfe.part9.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
