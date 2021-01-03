package com.example.springbootunitvsint.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
class HelloControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals("Hello, World", result.getResponse().getContentAsString());
    }

    @Test
    void hello_with_name() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello?name=John");
        mockMvc.perform(requestBuilder).andExpect(content().string("Hello, John"));
    }
}