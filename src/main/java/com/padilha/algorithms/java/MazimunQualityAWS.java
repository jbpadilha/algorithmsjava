package com.padilha.algorithms.java;

import java.util.List;
import java.util.stream.Collectors;

public class MazimunQualityAWS {
    /*
     * Complete the 'maximumQuality' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY packets
     *  2. INTEGER channels
     */

    public static long maximumQuality(List<Integer> packets, int channels) {
        // Write your code here
        int size = packets.size();
        double sum = 0;
        if(size == channels) {
            for(int i = 0;i<size;i++) {
                sum += packets.get(i);
            }
            return (long)sum;
        }
        List<Integer> sortedPackage = packets.stream().sorted().collect(Collectors.toList());

        for(int i = size - channels+1;i<size;i++) {
            sum += sortedPackage.get(i);
        }

        size = size - channels;
        if(size % 2 == 0) {
            sum += sortedPackage.get(size/2);
        }
        else {
            //even
            double value = sortedPackage.get(size/2) + sortedPackage.get((size/2) + 1);
            sum += value/2;
        }
        return (long)Math.ceil(sum);

    }

    public static void main(String[] args) {
        // {1,2,3,4,5}
        // channels 2
        // expect 8

        // {2,2,1,5,3}
        // channels 2
        // expect 7

        // {89, 48, 14
        // channles 3
        // expect 151
    }
}
