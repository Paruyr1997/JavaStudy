package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTest {
    @Test
    public void testCompare() {
        assertEquals(new NumberComparator().compare(5, 3), "5 > 3");
        assertEquals(new NumberComparator().compare(2, 4), "2 < 4");
        assertEquals(new NumberComparator().compare(7, 7), "7 == 7");
    }
}