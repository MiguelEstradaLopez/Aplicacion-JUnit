package com.example.junitdemo.web;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.junitdemo.service.CalculatorService;

@WebMvcTest(controllers = CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void addEndpoint() throws Exception {
        when(calculatorService.add(2, 3)).thenReturn(5);

        mvc.perform(get("/api/add").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void divideEndpoint() throws Exception {
        when(calculatorService.divide(10, 2)).thenReturn(5.0);

        mvc.perform(get("/api/divide").param("a", "10").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }
}
