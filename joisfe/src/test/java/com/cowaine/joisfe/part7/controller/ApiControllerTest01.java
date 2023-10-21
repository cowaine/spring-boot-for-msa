package com.cowaine.joisfe.part7.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cowaine.joisfe.part7.dto.HotelRequest;
import com.cowaine.joisfe.part7.util.JsonUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ApiControllerTest01 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetHotelById() throws Exception {

        HotelRequest hotelRequest = new HotelRequest("Ragged Point Inn");
        String jsonRequest = JsonUtil.objectMapper.writeValueAsString(hotelRequest);

        mockMvc.perform(post("/hotels/fetch-by-name")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("[{\"hotelId\":1000,\"hotelName\":\"ananty\",\"address\":\"busan ijanghaean\",\"phoneNumber\":\"010-****-****\"}]"))
                .andExpect(content().json("[{\"hotelId\":1000,\"hotelName\":\"ananty\",\"address\":\"busan ijanghaean\",\"phoneNumber\":\"010-****-****\"}]"))
                .andExpect(jsonPath("$[0].hotelId", Matchers.is(1000)))
                .andExpect(jsonPath("$[0].hotelName", Matchers.is("ananty")))
                .andDo(MockMvcResultHandlers.print(System.out));
    }

}
