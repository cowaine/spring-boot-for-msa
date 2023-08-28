package com.cowaine.crupy.part5.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class DeleteResultResponse {

    private boolean isSuccess;
    private String message;
}
