package com.cowaine.ahngilwoong.chapter9.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CreateCodeResponse {

    private List<Long> codes;

    public static CreateCodeResponse of(List<Long> codes) {
        CreateCodeResponse response = new CreateCodeResponse();
        response.codes = codes;
        return response;
    }
}
