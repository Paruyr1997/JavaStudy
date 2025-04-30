package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTest {
    @Test
    public void testAreaCalculation() {
        assertEquals(new TriangleArea().calculateArea(5, 4), 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeInput() {
        new TriangleArea().calculateArea(-1, 5);
    }
}