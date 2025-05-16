package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {
    @Test
    void testAreaCalculation() {
        assertEquals(10.0, new TriangleArea().calculateArea(5, 4));
    }

    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () ->
                new TriangleArea().calculateArea(-1, 5));
    }
}