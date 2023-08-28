package com.cowaine.youngjujang.ch5.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteResultResponse {
     private Boolean isSuccess;
     private String result;
}

