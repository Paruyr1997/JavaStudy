package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {
    @Test
    void testCompare() {
        assertEquals("5 > 3", new NumberComparator().compare(5, 3));
        assertEquals("2 < 4", new NumberComparator().compare(2, 4));
        assertEquals("7 == 7", new NumberComparator().compare(7, 7));
    }
}