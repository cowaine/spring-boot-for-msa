// package com.cowaine.corock.chapter09.adaptor;
//
// import com.cowaine.corock.chapter09.billing.CreateCodeResponse;
// import com.cowaine.corock.chapter09.controller.ApiResponse;
// import com.cowaine.corock.chapter09.controller.CreateCodeRequest;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.core.ParameterizedTypeReference;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Component;
// import org.springframework.web.reactive.function.client.WebClient;
// import org.springframework.web.util.UriComponentsBuilder;
// import reactor.core.publisher.Mono;
//
// import java.net.URI;
// import java.util.List;
//
// @Slf4j
// @Component
// public class WebClientBillingAdaptor {
//
//     public static final ParameterizedTypeReference<ApiResponse<CreateCodeResponse>> TYPE_REFERENCE;
//
//     static {
//         TYPE_REFERENCE = new ParameterizedTypeReference<>() {
//         };
//     }
//
//     private final WebClient webClient;
//
//     public WebClientBillingAdaptor(WebClient billingWebClient) {
//         this.webClient = billingWebClient;
//     }
//
//     /**
//      * {@link WebClient#mutate()} 메서드로 WebClient.Builder 를 다시 사용할 수 있음을 보여 준다.
//      * 설정 후 build() 메서드를 호출하면 다시 {@link WebClient} 객체를 반환받을 수 있다.
//      * <p>
//      * {@link WebClient#method(HttpMethod)} 를 사용하여 HTTP 메서드를 설정하고, {@link org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec#uri(URI)} 를 사용하여 URI 를 설정할 수 있다.
//      * 기존에 {@link com.cowaine.corock.chapter09.config.WebClientConfig} 에서 설정한 baseUrl() 설정이 있더라도 덮어쓴다.
//      * <p>
//      * 반환받은 {@link Mono} 를 {@link reactor.core.publisher.Flux} 로 변환한 후 다시 Java 8 의 {@link java.util.stream.Stream} 객체로 변환한다.
//      *
//      * @param hotelIds 호텔 아이디 목록
//      * @return 생성한 코드 응답 객체
//      */
//     public CreateCodeResponse createBillingCode(List<Long> hotelIds) {
//         URI uri = UriComponentsBuilder.fromPath("/billing-codes")
//                 .scheme("http").host("127.0.0.1").port(20420)
//                 .build(false).encode()
//                 .toUri();
//
//         CreateCodeRequest request = new CreateCodeRequest(1, hotelIds);
//
//         return webClient.mutate()
//                 .build()
//                 .method(HttpMethod.POST)
//                 .uri(uri)
//                 .bodyValue(request)
//                 .retrieve()
//                 .onStatus(httpStatus -> HttpStatus.OK != httpStatus,
//                         clientResponse -> {
//                             String message = "Error from Billing." + clientResponse.statusCode().value();
//                             return Mono.error(new RuntimeException(message));
//                         })
//                 .bodyToMono(TYPE_REFERENCE)
//                 .flux()
//                 .toStream()
//                 .findFirst()
//                 .map(ApiResponse::getData)
//                 .orElseThrow(() -> new RuntimeException("Empty response"));
//     }
//
// }
