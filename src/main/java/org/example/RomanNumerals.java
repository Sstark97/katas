package org.example;

import java.util.Map;

public class RomanNumerals {
    static Map<Integer, String> roman = Map.ofEntries(
            Map.entry(1, "I"),
            Map.entry(4, "IV"),
            Map.entry(5, "V"),
            Map.entry(9, "IX"),
            Map.entry(10, "X"),
            Map.entry(40, "XL"),
            Map.entry(49, "IL"),
            Map.entry(50, "L"),
            Map.entry(90, "XC"),
            Map.entry(100, "C"),
            Map.entry(400, "CD")
    );

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
