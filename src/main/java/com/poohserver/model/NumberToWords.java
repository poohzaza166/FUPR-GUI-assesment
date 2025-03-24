package com.poohserver.model;

import java.util.HashMap;
import java.util.Map;

public class NumberToWords {
    private static final Map<Integer, String> numberMap = new HashMap<>();
    private static final Map<String, Integer> wordMap = new HashMap<>();  // Reversed map

    static {
        numberMap.put(1, "one");
        numberMap.put(2, "two");
        numberMap.put(3, "three");
        numberMap.put(4, "four");
        numberMap.put(5, "five");
        numberMap.put(6, "six");
        numberMap.put(7, "seven");
        numberMap.put(8, "eight");
        numberMap.put(9, "nine");
        numberMap.put(10, "ten");
        numberMap.put(11, "eleven");
        numberMap.put(12, "twelve");
        numberMap.put(13, "thirteen");
        numberMap.put(14, "fourteen");
        numberMap.put(15, "fifteen");
        numberMap.put(16, "sixteen");
        numberMap.put(17, "seventeen");
        numberMap.put(18, "eighteen");
        numberMap.put(19, "nineteen");
        numberMap.put(20, "twenty");

        // Populate the reversed map
        for (Map.Entry<Integer, String> entry : numberMap.entrySet()) {
            wordMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static String numberToWords(int num) {
        return numberMap.getOrDefault(num, "Invalid number");
    }

    public static int wordsToNumber(String word) {
        return wordMap.getOrDefault(word.toLowerCase(), -1);  // Return -1 if word not found
    }
}
