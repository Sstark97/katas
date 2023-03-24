package org.example;

public class RomanNumerals {
    public static String transform(int number) {
        String numberInRoman = "I".repeat(number);
        return number > 3 ? "IV" : numberInRoman;
    }
}
