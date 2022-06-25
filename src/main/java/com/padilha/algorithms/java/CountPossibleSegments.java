package com.padilha.algorithms.java;

import java.util.List;

public class CountPossibleSegments {
    /*
     * Complete the 'countPossibleSegments' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY weights
     */

    public static long countPossibleSegments(int k, List<Integer> weights) {
        // Write your code here
        int count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < weights.size(); i++ ) {
            max = Math.max(max, weights.get(i));
            min = Math.min(min, weights.get(i));
            if (max - min > k) {
                return count;
            }
            count++;

        }
        return count;

    }

    public static void main(String[] args) {
        /*
        k = 3
        weights = [1,3,6]
        expect: 5
         */
    }

}
