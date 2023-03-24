package org.example;

public class RomanNumerals {
    public static String transform(int number) {
        String numberInRoman = number < 4 ? "I".repeat(number) : "IV";
        return number > 4 ? "V" : numberInRoman;
    }
}
