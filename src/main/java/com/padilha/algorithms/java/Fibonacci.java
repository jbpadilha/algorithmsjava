package com.padilha.algorithms.java;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n == 0 || n==1) {
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {
        int count = 10;
        for (int i = 0; i < count; i++) {
            System.out.println(fibonacci(i)+ "");
        }
    }
}
