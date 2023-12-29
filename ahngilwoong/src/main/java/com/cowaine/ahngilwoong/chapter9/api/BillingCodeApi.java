package com.cowaine.ahngilwoong.chapter9.api;

import com.cowaine.ahngilwoong.chapter9.model.ApiResponse;
import com.cowaine.ahngilwoong.chapter9.model.BillingCodeResponse;
import com.cowaine.ahngilwoong.chapter9.model.CreateCodeRequest;
import com.cowaine.ahngilwoong.chapter9.model.CreateCodeResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class BillingCodeApi {

    @PostMapping(path = "/billing-codes")
    public ApiResponse<CreateCodeResponse> createBillingCodes(@RequestBody CreateCodeRequest request) {

        return ApiResponse.ok(CreateCodeResponse.of(request.getIds()));
    }

    @GetMapping(path = "/billing-codes")
    public ApiResponse<List<BillingCodeResponse>> getBillingCodes() {
        List<BillingCodeResponse> responses = List.of(
            BillingCodeResponse.of("CODE-112123"),
            BillingCodeResponse.of("CODE-827125")
        );

        return ApiResponse.ok(responses);
    }
}
