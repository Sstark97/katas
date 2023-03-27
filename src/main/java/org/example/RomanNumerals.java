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
            Map.entry(50, "L"),
            Map.entry(90, "XC"),
            Map.entry(100, "C"),
            Map.entry(400, "CD"),
            Map.entry(500, "D")
    );

    public static String transform(int number) {
        var romanList = RomanNumerals.roman.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed()).toList();
        StringBuilder result = new StringBuilder();
        int i = 0;

        // Iterate over the map
        while (number > 0) {
            var romanEntry = romanList.get(i);
            i += number < romanEntry.getKey() ? 1 : 0;

            if(number >= romanEntry.getKey()) {
                result.append(romanEntry.getValue());
                number -= romanEntry.getKey();
            }
        }

        return result.toString();
    }
}
