package com.example;

public class FactorialCalculator {
    public long calculateFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Число не может быть отрицательным");
        return n == 0 ? 1 : n * calculateFactorial(n - 1);
    }
}
