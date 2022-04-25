package com.padilha.algorithms.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LogestUniformString {

    private static int[] longestUniformSubstring(String input) {

        if(input == null || input.length() == 0)
            return new int[]{-1,0};

        int longestStart = 0;
        int longestLength = 0;

        int start = 0;
        int count = 1;
        for(int i=1; i< input.length() ; i++){
            if(input.charAt(i)==input.charAt(i-1)){
                count++;
            }
            else{
                if(count>longestLength){
                    longestStart = start;
                    longestLength = count;
                }
                start = i;
                count=1;
            }
        }

        if(count>longestLength){
            longestStart = start;
            longestLength = count;
        }

        System.out.println(longestStart+"  "+longestLength);

        return new int[]{longestStart, longestLength};
    }


    public static void main(String[] args) {
        Map<String, int[]> testCases = new HashMap<>();
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});
        testCases.put("aaabbccccxxxxxx", new int[]{9, 6});
        testCases.put("aaa", new int[]{0, 3});
        testCases.put("abba", new int[]{1, 2});
        testCases.put("aba", new int[]{0, 1});
        testCases.put(null, new int[]{-1, 0});


        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }

}
