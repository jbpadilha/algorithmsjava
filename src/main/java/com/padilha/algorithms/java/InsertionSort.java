package com.padilha.algorithms.java;

import java.util.Arrays;

/**
 * Time complexity quite fast for small list
 * 10 -> 26 iterations
 * 20 -> 98 iterations
 * 30 -> 215 iterations
 * 40 -> 377 iterations
 * O(n^2) in worst case
 *
 */
public class InsertionSort {
    public static void insertionSort(int array[]) {
        int n = array.length;
        int count = 0;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            count++;
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
                count++;
            }
            array[i+1] = key;
        }
        System.out.println(count+" iterations");
    }

    public static void main(String a[]){
        int[] arr1 = {9,14,3,2,43,11,58,22,30,10};
        System.out.println("Before Insertion Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();

        insertionSort(arr1);//sorting array using insertion sort

        System.out.println("After Insertion Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
    }
}
