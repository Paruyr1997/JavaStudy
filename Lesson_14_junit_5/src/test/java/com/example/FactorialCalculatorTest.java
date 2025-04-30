package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {
    @Test
    void testFactorialOf5() {
        assertEquals(120, new FactorialCalculator().calculateFactorial(5));
    }

    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () ->
                new FactorialCalculator().calculateFactorial(-1));
    }
}
