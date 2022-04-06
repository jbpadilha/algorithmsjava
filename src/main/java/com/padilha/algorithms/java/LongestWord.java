package com.padilha.algorithms.java;

import java.util.Arrays;

public class LongestWord {

    public static String longestWord(String[] words){

        // First Way
        String loggest = "";
        int nLongWord = 0;
        for (String word: words) {
            if (word.length() > nLongWord) {
                loggest = word;
            }
        }
        return loggest;
    }

    public static String longestWordSimple(String[] words) {
        String loggest = "";
        loggest = Arrays.asList(words).stream().max((word, word2) -> word.length() > word2.length() ? 1 : -1).get();
        return loggest;
    }

    public static void main(String[] args) {
        String dict[]=new String[]{"to", "toe","toee","oeet", "toes", "doe", "dog", "god", "dogs", "banana"};

        System.out.println("First Way: "+ longestWord(dict));

        System.out.println("Second Simple Way: "+ longestWordSimple(dict));
    }
}
