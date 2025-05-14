package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {
    @Test
    void testAdd() {
        assertEquals(5, new ArithmeticOperations().add(2, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () ->
                new ArithmeticOperations().divide(5, 0));
    }
}