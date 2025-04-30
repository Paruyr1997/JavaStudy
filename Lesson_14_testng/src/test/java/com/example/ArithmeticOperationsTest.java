package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTest {
    @Test
    public void testAdd() {
        assertEquals(new ArithmeticOperations().add(2, 3), 5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        new ArithmeticOperations().divide(5, 0);
    }
}
