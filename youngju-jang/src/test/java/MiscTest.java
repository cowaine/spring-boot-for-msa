import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class MiscTest {
     
     @BeforeAll
     public static void setup(){
          // 테스트클래스 인스턴스 초기화시 사장먼저 실행. 한번만 실행됨.
          // 객체생성전에 실행하므로 static 필요
          log.info("@BeforeAll) before all tests in the current test class");
     }
     
     @BeforeEach // 테스트 하나 새로시작하기 전마다 실행
     public void init(){
          log.info("@BeforeEach) before each @Test");
     }
     @Test
     public void testHashSetContainsNonDuplicatedValue(){
          // 규칙1) public method 일것
          // 규칙2) return void
          // 규칙3) 보통 메서드 이름 : test~~
          
          // Given 입력값 파트
          Integer value = Integer.valueOf(1);
          Set<Integer> set = new HashSet<>();
          
          // When 실행 조건 파트
          set.add(value);
          set.add(value);
          set.add(value);
          
          // Then 검증 파트
          Assertions.assertEquals(1, set.size());
          Assertions.assertTrue(set.contains(value));
          log.info("@Test) 1번 test");
     }
     
     @Test
     public void testDummy(){
          Assertions.assertTrue(Boolean.TRUE);
          log.info("@Test) 2번 test");
     }
     
     @AfterEach // test 하나 실행끝날때마다 실행
     public void cleanup(){
          log.info("@AfterEach) after each @Test");
     }
     
     @AfterAll
     public static void destroy(){
          // 마찬가지로 static
          // 한번만실행됨
          log.info("@AfterAll) after all tests in the current test class");
     }
}
