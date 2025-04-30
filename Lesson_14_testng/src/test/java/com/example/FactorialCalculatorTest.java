package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTest {
    @Test
    public void testFactorialOf5() {
        assertEquals(new FactorialCalculator().calculateFactorial(5), 120L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeInput() {
        new FactorialCalculator().calculateFactorial(-1);
    }
}