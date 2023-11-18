package com.cowaine.corock.chapter09.adaptor;

import com.cowaine.corock.chapter09.billing.CreateCodeResponse;
import com.cowaine.corock.chapter09.controller.ApiResponse;
import com.cowaine.corock.chapter09.controller.CreateCodeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PoolingBillingAdaptor {

    private static final ParameterizedTypeReference<ApiResponse<CreateCodeResponse>> TYPE_REFERENCE;

    static {
        TYPE_REFERENCE = new ParameterizedTypeReference<>() {
        };
    }

    private final RestTemplate poolingRestTemplate;

    public CreateCodeResponse createBillingCode(List<Long> hotelIds) {
        URI uri = UriComponentsBuilder.fromPath("/billing-codes")
                .scheme("http").host("127.0.0.1").port(8080)
                .build(false).encode()
                .toUri();

        CreateCodeRequest request = new CreateCodeRequest(1, hotelIds);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateCodeRequest> httpEntity = new HttpEntity<>(request, headers);

        ResponseEntity<ApiResponse<CreateCodeResponse>> responseEntity =
                poolingRestTemplate.exchange(uri, HttpMethod.POST, httpEntity, TYPE_REFERENCE);

        if (HttpStatus.OK != responseEntity.getStatusCode()) {
            log.error("Error from Billing. status:{}, hotelIds:{}", responseEntity.getStatusCode(), hotelIds);
            throw new RuntimeException("Error from Billing. " + responseEntity.getStatusCode());
        }

        return responseEntity.getBody().getData();
    }

}
