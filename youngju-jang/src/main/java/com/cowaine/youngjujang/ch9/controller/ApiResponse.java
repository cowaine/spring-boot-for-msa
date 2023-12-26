package com.cowaine.youngjujang.ch9.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> { // Response객체 통일용
     
     private boolean success;
     private String resultMessage;
     
     private T data;
     
     public ApiResponse(boolean success, String resultMessage) {
          this.success = success;
          this.resultMessage = resultMessage;
     }
     
     public static <T> ApiResponse ok(T data) {
          ApiResponse apiResponse = new ApiResponse(true, "success");
          apiResponse.data = data;
          return apiResponse;
     }
}
