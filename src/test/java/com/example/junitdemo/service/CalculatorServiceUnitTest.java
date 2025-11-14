package com.example.junitdemo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceUnitTest {

    @Test
    void testAdd() {
        CalculatorService s = new CalculatorService();
        assertEquals(5, s.add(2, 3));
    }

    @Test
    void testDivide() {
        CalculatorService s = new CalculatorService();
        assertEquals(5.0, s.divide(10, 2), 1e-9);
    }

    @Test
    void testDivideByZero() {
        CalculatorService s = new CalculatorService();
        assertThrows(ArithmeticException.class, () -> s.divide(1, 0));
    }
}
