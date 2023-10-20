# Chapter07 정리

## 7.1 스프링 AOP

### AOP

1. 대상객체 (target object): 공통 모듈을 적용할 대상을 의미한다. 이때 HotelDisplayService 객체가 대상 객체고, 공통 모듈은 Logging이다.
2. 관점(Aspect): AOP 프로그래밍으로 작성한 공통 모듈과 적용될 위치 정보의 조합을 의미한다. 관점은 어드바이스와 포인트 컷을 합친 것이다.
- CommonLoggingAspect.java 클래스를 관점이라 한다.
- 해당 클래스는 공통 모듈인 어드바이스와 HotelDisplayService의 getHotelByName() 메서드 위치 정보가 있는 포인트 컷을 포함하고있다.
3. 어드바이스(advice): 애플리케이션의 공통 로직이 작성된 모듈을 의미한다.
- 스프링 AOP에서 어드바이스는 메서드 형태이다.
4. 포인트 컷(point cut): 어드바이스를 적용할 위치를 선정하는 설정을 의미한다.
- 특정 어노테이션을 지정가능
- 특정 클래스의 메서드 지정가능

---

### aspect 패키지의 메서드 실행 순서

1. [ArgumentLoggingAspect](../aspect/ArgumentLoggingAspect.java)의 의 `Before` 어드바이스
2. [ElapseLogging](../aspect/ElapseLoggingAspect.java)의 `Around` 어드바이스의 **전반부**
3. [HotelDisplayService](../service/HotelDisplayService.java)의 `getHotelsByName()` 메서드
4. [ElapseLogging](../aspect/ElapseLoggingAspect.java)의 `Around` 어드바이스의 **후반부**
5. [ReturnValueLoggingAspect](../aspect/ReturnValueLoggingAspect.java)의 `AfterReturning` 어드바이스

---

## 7.2 스프링 부트 테스트

### 좋은 단위 테스트 케이스의 작성 (F.I.R.S.T)

1. F(Fast): 테스트 케이스는 빠르게(fast) 동작해야 한다.
2. I(Isolated): 테스트 케이스는 다른 외부 요인에 영향을 받지 않도록 격리(isolated) 해야 한다.
3. R(Repeatable): 테스트 케이스는 반복(repeat)해서 실행하고, 실행할 때 마다 매번 같은 결과를 확인할 수 있어야 한다.
4. S(Self-validating): 테스트 케이스 내부에는 결과 값을 자체 검증 할 수 있는 코드가 필요하다.
5. T(Timely): 실제 코드를 개발하기 전 테스트 케이스를 먼저 작성하는 것을 의미한다.

### 7.2.1 스프링 부트 테스트 설정

- 의존성 추가

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
</dependency>
```

해당 의존성을 추가하면 `Junit`과 `Hamcrest`, `Mockito`, `spring-test`, `spring-boot-test`, `spring-boot-test-autoconfiguration`
을 포함하고 있다.

### 7.2.2 Junit Test

Junit `@Test` 애너테이션은 테스트 메서드를 정의 할 때 사용한다.
테스트 메서드는 규칙을 지켜야한다.

1. 접근 제어자는 `public`이어야 한다.
2. 리턴 타입은 `void`다.
3. 테스트 메서드의 이름은 `test`로 시작하는 것이 **일반적**이다.

사용되는 어노테이션

- `@BeforeAll`: 테스트 클래스 인스턴스를 초기화 할 때 가장 먼저 실행, 따라서 `static` 정의 되어야 함. (한번만 실행 됨)
- `@BeforeEach`: 모든 테스트 메서드가 **실행되기 전** 각각 한 번씩 실행된다. (여러 번 실행 될 수 있음)
- `@AfterEach`: 모든 테스트 메서드가 **실행된 후** 각각 한 번씩 실행된다. (여러 번 실행 될 수 있음)
- `@AfterAll`: 테스트 클래스 모든 테스트 메서드가 실행을 마치면 마지막으로 한번 실행된다. `static`으로 정의 되어야 함.

### 7.2.3 SpringBootTest

`@SpringBootTest` 애너테이션의 `properties` 속성을 사용하여 프로퍼티 설정이 가능하다.
해당 속성을 사용하게 되면 해당 테스트 클래스에서만 유효하다.

```java
@SpringBootTest(properties={"search.host = 127.0.0.1", "search.port=19999"})
@SpringBootTest(properties={"spring.config.location=classpath:application-on-test.properties"})
```

### 7.2.4 `@TestConfiguration`을 사용한 테스트 환경 설정

테스트 환경과 운영 환경은 분리 되어야 한다.
해당 환경에 알맞는 Configuration 분리를 위해 사용한다.

`@TestConfiguration`과 `@Configruation`의 차이점

- `@TestConfiguration`은 테스트 환경에서만 유요한 스프링 빈을 추가로 정의할 수 있다.
- 실행 환경에 중복된 스프링 빈이 있다면 `@TestConfiguration`의 설정으로 대체 된다.
- `@Configruation`은 `@SpringBootConfiguration`이 자동으로 스캔한 후 로딩되지만, `@TestConfiguration`은 그렇지 않다.(명시적으로 로딩 해야한다.)
- `@Configuration` 은 src/main 디렉터리를 참조하고, `@TestConfiguration`은 src/test 디렉터리를 참조한다.

스프링 빈의 재정의를 위해서는 스프링 부트 프레임워크에 추가 설정이 필요하다.
스프링 부트 프레임워크의 기본값은 빈 재정의를 허용하지 않는다.

아래의 설정을 추가해야만 `빈 재정의`가 가능해진다.

```properties
spring.main.allow-bean-definition-overriding=true
```

### 7.2.5 `@MockBean`을 사용한 테스트 환경 설정

- `@Mock` 애너테이션은 일반 자바 객체를 테스트 하는 데 사용한다.
- `@MockBean` ApplicationContext를 사용하여 주입된 스프링 빈을 목 객체로 만들기 위해 사용한다.

### 7.2.6 테스트 슬라이스 애너테이션

`@SpringBootTest` 애너테이션의 실행은 `ApplicationContext`를 이용하여 스프링 빈을 스캔하고 의존성을 주입한다.
그 덕에 성능이 낮아진다.

개선 방법으로 `테스트 슬라이스` 개념을 제공한다. -e.g `@Controller`의 웹 MVC 기능만 테스트 시 HTTP 파라미터가 변경되는지, 응답 코드가 적절한지
테스트 하려면 웹 MVC만 테스트 하면 됨.

테스트 슬라이스 기법을 적용하는 애너테이션은?

1. `@WebMvcTest`: 스프링 MVC 프레임워크의 기능을 테스트할 수 있다. `@Controller`, `@ControllerAdvice` 를 스캔하고 Converter, Filter, 
   WebMvcConfigurer 같은 MVC 기능도 제공한다.
2. `@DataJpaTest`: 데이터 영속성 프레임워크인 JPA 기능을 테스트 할 수 있다. EntityManager, TestEntityManager, DataSource 기능을 사용할 수 있다.
3. `@JsonTest`: Json 직렬화, 역직렬화 테스트를 할 수 있다. `@JsonComponent`, ObjectMapper 같은 기능을 테스트할 수 있다.
4. `@RestClientTest`: HTTP 클라이언트의 동작을 테스트할 수 있는 기능을 제공한다. MockRestServiceServer와 Jackson 자동 설정 기능을 제공한다.
5. `@DataMongoTest`: MongoDB를 테스트하기 위해 Mongo Template, CrudRepository 같은 기능을 테스트할 수 있다.

### 7.2.7 스프링 부트 웹 MVC 테스트

테스트 패키지의 ControllerTest01, 02를 참조할 것.

---

## 7.3 스프링 부트 자동 설정

스프링 부트는 보편적으로 자주 사용하는 형태로 기술을 미리 설정하여 제공한다.
자동 설정의 핵심은 `@SpringBootApplication`에 포함되어 있는 `@EnableAutoConfiguration`이다.

