package com.cowaine.youngjujang.ch7.domain.controller;

import com.cowaine.youngjujang.ch7.util.JsonUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc // MockMvc객체를 스프링빈으로 주입받을 수 있음. @SpringBootTest이랑 같이쓰는편
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ApiControllerTest01 {
     
     @Autowired
     private MockMvc mockMvc;
     
     @Test
     public void testGetHotelById() throws Exception{
          HotelRequest hotelRequest = new HotelRequest("Ragged Point Inn");
          String jsonRequest = JsonUtil.objectMapper.writeValueAsString(hotelRequest); // json2String
          
          mockMvc.perform(post("/hotels/fetch-by-name")
                    .content(jsonRequest) // json body
                    .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$[0].hotelId", Matchers.is(1000))) // 리턴된 객체의 json 내부값 확인
               .andExpect(jsonPath("$[0].hotelName", Matchers.is("Ragged Point Inn"))) // $: 최상위 root. $[index].자식name
               .andDo(MockMvcResultHandlers.print(System.out));
               
     }
}
