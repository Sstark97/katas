package org.example;

import java.util.Map;

public class RomanNumerals {
    static Map<Integer, String> roman = Map.of(
            1, "I",
            4, "IV",
            5, "V",
            9, "IX",
            10, "X",
            40, "XL"
    );
    public static void main (String[] args) {
        int number = 50;

        var test = RomanNumerals.roman.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed()).iterator();

        // Iterate over the map
        while (test.hasNext()) {
            var entry = test.next();
            while(number >= entry.getKey()) {
                // if number is greater than key, print value
                System.out.print(entry.getValue());
                // subtract key from number
                number -= entry.getKey();
            }
        }

    }
    public static String transform(int number) {
        var romanIterator = RomanNumerals.roman.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed()).iterator();
        String result = "";

        // Iterate over the map
        while (romanIterator.hasNext()) {
            var entry = romanIterator.next();
            while(number >= entry.getKey()) {
                // if number is greater than key, print value
                result += entry.getValue();
                // subtract key from number
                number -= entry.getKey();
            }
        }

        return result;
    }
}
