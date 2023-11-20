package com.cowaine.ahngilwoong.chapter9.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private boolean success;
    private String resultMessage;

    private T data;

    private ApiResponse(boolean success, String resultMessage) {
        this.success = success;
        this.resultMessage = resultMessage;
    }

    public ApiResponse() {
    }

    public static <T> ApiResponse ok(T data) {
        ApiResponse apiResponse = new ApiResponse(true, "success");
        apiResponse.data = data;
        return apiResponse;
    }
}
