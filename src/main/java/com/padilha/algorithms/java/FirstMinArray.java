package com.padilha.algorithms.java;

/*
 * In this coding challenge you will be implementing a class to assist with stock trading.
 * Your investment firm's analytics team has predicted how the price of a certain stock will change during the day.
 * They send you this data as an array of stock prices within a day ordered based on time.
 * Your task is to figure out when to buy/sell this stock to maximize profit.
 *
 * Definitions:
 *
 * 1) Local minima (Lmin): A local minima is a point where all values nearby are above or equal to this value.
 *    For example, in the array [4, 2, 5, 1, 3] the first local minima is at index 1.
 *    The second local minima is at index 3.
 *
 * 2) Local maxima (Lmax): A local maxima is a point where all values nearby are below or equal to this value.
 *    For example, in the array [4, 7, 5, 6, 8] the first local maxima is at index 1.
 *    The second local maxima is at index 4.
 *
 *             ▲
 *             │       * (Lmax)
 *             │      / \
 *             │     /   \        /\
 *             │\   /     \      /  \
 *       price │ \ /       \  /\/    \
 *             │  * (Lmin)  \/        \      /
 *             │                       \/\  /
 *             │                          \/
 *             ─────────────────────────────────▶
 *                          time
 */

public class FirstMinArray {

    /*
    Finds the first local minima of the subarray between leftIndex and rightIndex inclusive and return it's index.
    A local minima is a point where all values nearby are above or equal to this value. For example [4, 2, 5, 1, 3] 0, 4
    {4, 2, 5, 1, 3}, 2, 4
    {5, 4, 3, 2, 1}, 0, 4
    have the first local minima at index 1. You may assume leftIndex and rightIndex are valid indices for array.
    */
    public static int findFirstLocalMin(int[] array, int leftIndex, int rightIndex) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int prev = Integer.MIN_VALUE;
        int next =  Integer.MIN_VALUE;
        int localFirtMin = Integer.MAX_VALUE;

        for (int i = leftIndex; i <= rightIndex; i ++) {
            if (i +1 <= rightIndex) {
                next = array[i+1];
            }
            if (prev >= array[i] && (next >= array[i] || next < array[i])) {
                localFirtMin = array[i];
                break;
            }
            prev = array[i];
        }

        return localFirtMin;
    }

    /*
    Finds the first local maxima of the subarray between leftIndex and rightIndex inclusive and return it's index. A
    local maxima is a point where all values nearby are below or equal to this value. For example [4, 7, 5, 8, 6] have
    the first local maxima at index 1. You may assume leftIndex and rightIndex are valid indices for array.
    */
    public static int findFirstLocalMax(int[] array, int leftIndex, int rightIndex) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int prev = Integer.MIN_VALUE;
        int next =  Integer.MIN_VALUE;
        int localFirtMax = Integer.MAX_VALUE;

        for (int i = leftIndex; i <= rightIndex; i ++) {
            if (i +1 <= rightIndex) {
                next = array[i+1];
            }
            if (prev <= array[i] && (next <= array[i] || next > array[i])) {
                localFirtMax = array[i];
                if (next < array[i]) {
                    break;
                }
            }
            prev = array[i];
        }

        return localFirtMax;
    }


    /*
   Given the prices of a stock in a day ordered by time, find and return the maximum profit you can make in the day by
   performing any number of trades. A new trade can only start after the previous trade (buy&sell) is complete. If no profit can be made in the day, return 0
   */
    public static int findMaxProfitFromMultipleTrades(int[] prices) {
        int totalProfit = 0;
        if (prices == null || prices.length == 1 || (prices.length % 2 == 1)) {
            return 0;
        }
        int pos = 0;
        int prevN = 0;
        for (int i = 0; i < prices.length; i++) {
            if (pos == 1) {
                totalProfit += prices[i] - prevN;
                pos = 0;
            } else {
                prevN = prices[i];
                pos = 1;
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) throws Exception {
        //         // findFirstLocalMin
//         // Index 4 is the first local min because we reached the end of the array and the numbers are
//         // still decreasing
        test(1, 4, findFirstLocalMin(new int[] {5, 4, 3, 2, 1}, 0, 4));
         test(2, 2, findFirstLocalMin(new int[] {4, 2, 5, 1, 3}, 0, 4));
         test(3, 1, findFirstLocalMin(new int[] {4, 2, 5, 1, 3}, 2, 4));
        test(4, 5, findFirstLocalMin(new int[] {2, 5, 7, 5, 8}, 0, 4));

//         // findFirstLocalMax
//         // Index 4 is the first local max because we reached the end of the array and the numbers are
//         // still increasing
         test(4, 5, findFirstLocalMax(new int[] {1, 2, 3, 4, 5}, 0, 4));
         test(5, 7, findFirstLocalMax(new int[] {4, 7, 5, 8, 6}, 0, 4));
        test(6, 8, findFirstLocalMax(new int[] {4, 7, 5, 8, 6}, 2, 4));


//         // findMaxProfitFromMultipleTrades
//         // buy at 1 and sell at 41 to get profit of 40
         test(7, 40, findMaxProfitFromMultipleTrades(new int[] {1, 4, 6, 8, 9, 20, 30, 40, 41, 55}));
//         // cannot buy and then sell to make a profit
//         test(8, 0, findMaxProfitFromMultipleTrades(new int[] {41, 40, 30, 20, 9, 8, 6, 4, 1}));
//         // buy@1, sell@4, buy@2, sell@5, buy@3, sell@19, buy@2, sell@10
//         // total profit = (4 - 1) + (5 - 2) + (19 - 3) + (10 - 2) = 3 + 3 + 16 + 8 = 30
//         test(9, 30, findMaxProfitFromMultipleTrades(new int[] {1, 4, 2, 5, 4, 3, 7, 19, 2, 10}));
    }

    public static void test(int testNumber, int expect, int actual) throws Exception {
        if (expect != actual) {
            throw new Exception("Test" + testNumber + " failed! Expected " + expect + " but got " + actual);
        }
    }
}
