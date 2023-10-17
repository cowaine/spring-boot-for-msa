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
5. [ReturnValueLoggingAspect]의 `AfterReturning` 어드바이스

---
