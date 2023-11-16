package com.cowaine.corock.chapter07.controller;

import com.cowaine.corock.chapter07.dto.HotelRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class HotelControllerSpringBootTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testGetHotelByName() throws Exception {
        HotelRequest hotelRequest = new HotelRequest("Ragged Point Inn");
        String jsonRequest = objectMapper.writeValueAsString(hotelRequest);

        mockMvc.perform(post("/hotels/fetch-by-name")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                // .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // .andExpect(jsonPath("$[0].hotelId", Matchers.is(1_000)))
                // .andExpect(jsonPath("$[0].hotelName", Matchers.is("Ragged Point Inn")))
                .andDo(MockMvcResultHandlers.print());
    }

}
