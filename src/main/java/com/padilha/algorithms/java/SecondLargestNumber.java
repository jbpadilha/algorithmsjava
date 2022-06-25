package com.padilha.algorithms.java;

import org.springframework.util.Assert;

// Java program to find second largest
public class SecondLargestNumber {

    public static int secondLargestNumber(int[] arr, int length) {
        if (arr == null || length == 1) {
            return 0;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i=0; i< length; i++){
            if (arr[i] > first) {
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        if (second == Integer.MIN_VALUE) {
            System.out.println("There is no Second Largest");
            return 0;
        }
        return second;
    }

    public static void test(int[] arr, int expect) {
        if(secondLargestNumber(arr, arr.length) == 34){
            System.out.println("Passed");
        }
    }
    public static void main(String[] args) {
        int arr[] = { 12, 35, 1, 10, 34, 1 };
        int n = arr.length;
        System.out.println(" Test 1 - { 12, 35, 1, 10, 34, 1 }");
        test(arr, n);
    }
}
