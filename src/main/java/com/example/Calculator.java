package com.example;

public class Calculator {
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
public static double divide(double a, double b) {
    if (b == 0.0) {
        // choose safe policy: throw to avoid silent infinity
        throw new IllegalArgumentException("Cannot divide by zero");
    }
    return a / b;
}

    public static void main(String[] args) { System.out.println("2+3=" + add(2,3)); }
}
