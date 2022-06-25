package com.padilha.algorithms.java;

import java.util.Arrays;

public class MinElementRotatedArray {


    // Java 8 Solution
    public static String findMinRounded(int n, int arr[]) {
        if (arr.length == 0) {
            return "";
        }
        Integer minN = Arrays.stream(arr).min().orElse(0);
        return minN.toString();
    }

    // Binary Search solution
    public static String findMinRoundedBinary(int n, int arr[]){
        if (n == 0) {
            return "";
        }
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[high])
                low=mid+1;
            else
                high=mid;
        }
        return Integer.toString(arr[low]);

    }

    public static void main(String[] args) {
        int arr[]={16,19,21,25,3,5,8,10};
        if ("3".equals(findMinRounded(8, arr))){
            System.out.println("Passed - Java 8 Solution");
        } else {
            System.out.println("Failed - Java 8 Solution");
        }

        if ("3".equals(findMinRoundedBinary(8, arr))){
            System.out.println("Passed - Binary Solution");
        } else {
            System.out.println("Failed - Binary Solution");
        }

        int arr1[]={3,5,8,10,16,19,21,25};
        if ("3".equals(findMinRoundedBinary(8, arr1))){
            System.out.println("Passed - Binary Solution");
        } else {
            System.out.println("Failed - Binary Solution");
        }
    }
}
