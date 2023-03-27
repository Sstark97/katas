package org.example;

import java.util.List;
import java.util.Map;

public class RomanNumerals {
    public static final int ROMAN_MAX_NUMBER = 3000;
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
            Map.entry(500, "D"),
            Map.entry(900, "CM"),
            Map.entry(1000, "M")
    );

    public static String transform(int number) throws RomamNumberMaximumException {
        checkThatIsAValid(number);

        var romanList = transformRomanMapIntoList();
        StringBuilder romanNumber = new StringBuilder();
        int i = 0;

        while (number > 0) {
            var romanEntry = romanList.get(i);
            i += number < romanEntry.getKey() ? 1 : 0;

            if(number >= romanEntry.getKey()) {
                romanNumber.append(romanEntry.getValue());
                number -= romanEntry.getKey();
            }
        }

        return romanNumber.toString();
    }

    private static void checkThatIsAValid(int number) throws RomamNumberMaximumException {
        if(number > ROMAN_MAX_NUMBER) {
            throw new RomamNumberMaximumException("The maximum roman number is 3000");
        }
    }

    private static List<Map.Entry<Integer, String>> transformRomanMapIntoList() {
        return RomanNumerals.roman.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed()).toList();
    }
}
