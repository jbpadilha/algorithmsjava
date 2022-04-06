package com.padilha.algorithms.java;

public class CustomDecimalConvertion {

    public static int getDecimalConvertion(int binary) {
        int decimal = 0;
        int n = 0;

        while(true) {
            if(binary == 0) {
                break;
            } else {
                int temp = binary % 10;
                decimal+= temp * Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(getDecimalConvertion(1010));
        System.out.println(getDecimalConvertion(10101));
        System.out.println(getDecimalConvertion(11111));
        System.out.println(getDecimalConvertion(111111));
    }
}
