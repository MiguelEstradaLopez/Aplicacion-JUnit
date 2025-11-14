package com.example.junitdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    CalculatorService calculatorService;

    @Test
    void testAdd() {
        int result = calculatorService.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    void testDivide() {
        double result = calculatorService.divide(10, 2);
        assertEquals(5.0, result, 1e-9);
    }

    @Test
    void testDivideByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calculatorService.divide(1, 0));
    }
}
