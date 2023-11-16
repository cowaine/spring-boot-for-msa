package com.cowaine.youngjujang.ch9.adapter;

import com.cowaine.youngjujang.ch9.controller.ApiResponse;
import com.cowaine.youngjujang.ch9.controller.BillingCodeResponse;
import com.cowaine.youngjujang.ch9.controller.CreateCodeRequest;
import com.cowaine.youngjujang.ch9.controller.CreateCodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class BillingAdapter {
     
     private static final ParameterizedTypeReference<ApiResponse<CreateCodeResponse>> TYPE_REFERENCE;
     
     static {
          TYPE_REFERENCE = new ParameterizedTypeReference<>() {
          };
     }
     
     private final RestTemplate restTemplate;
     
     public BillingAdapter(RestTemplate restTemplate) {
          this.restTemplate = restTemplate;
     }
     
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
               restTemplate.exchange(uri, HttpMethod.POST, httpEntity, TYPE_REFERENCE);
          
          if (HttpStatus.OK != responseEntity.getStatusCode()) {
               log.error("Error from Billing. status:{}, hotelIds:{}", responseEntity.getStatusCode(), hotelIds);
               throw new RuntimeException("Error from Billing. " + responseEntity.getStatusCode());
          }
          
          return responseEntity.getBody().getData();
     }
     
     public CreateCodeResponse create(List<Long> hotelIds) {
          
          URI uri = UriComponentsBuilder.fromPath("/billing-codes")
               .scheme("http").host("127.0.0.1").port(8080)
               .build(false).encode()
               .toUri();
          
          CreateCodeRequest request = new CreateCodeRequest(1, hotelIds);
          
          ResponseEntity<ApiResponse> responseEntity =
               restTemplate.postForEntity(uri, request, ApiResponse.class);
          
          if (HttpStatus.OK != responseEntity.getStatusCode()) {
               log.error("Error from Billing. status:{}, hotelIds:{}", responseEntity.getStatusCode(), hotelIds);
               throw new RuntimeException("Error from Billing. " + responseEntity.getStatusCode());
          }
          
          ApiResponse apiResponse = responseEntity.getBody();
          Map<String, List<Long>> dataMap = (Map) apiResponse.getData();
          return CreateCodeResponse.of(dataMap.get("codes"));
     }
     
     // Get Method 예제
     public List<BillingCodeResponse> getBillingCodes(String codeNameParam) { // List<BillingCodeResponse> : Response 의 Data 부분이 될 것
          UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/billing-codes") // fromPath : 서버 리소스경로 입력
               .scheme("http").host("127.0.0.1").port(8080); // 프로토콜, 서버주소, 포트 설정
          
          if (Objects.nonNull(codeNameParam))
               builder.queryParam("codeName", codeNameParam);
          
          URI uri = builder.build(false).encode().toUri();
          
          // getForEntity : Get메서드 기본임
          ResponseEntity<ApiResponse> responseEntity = restTemplate.getForEntity(uri, ApiResponse.class); // get이 기본. uri, 클래스타입 받아 서버에 요청함
          if (HttpStatus.OK != responseEntity.getStatusCode()) {// response 응답메시지 상태코드를 HttpStatus로 변환 . 실패여부 확인
               log.error("Error from Billing. status:{}, param:{}", responseEntity.getStatusCode(), codeNameParam);
               throw new RuntimeException("Error from Billing. " + responseEntity.getStatusCode());
          }
          
          ApiResponse apiResponse = responseEntity.getBody(); // 응답 메시지 바디값 리턴, getForEntity(uri, ApiResponse.class)의 인자타입으로.
          return (List<BillingCodeResponse>) apiResponse.getData(); // ApiResponse 제네릭설정안했으니 data : Object >> 타입캐스팅 해줌
     }
}
