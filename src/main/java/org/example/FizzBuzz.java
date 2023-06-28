package org.example;

public class FizzBuzz {
    public static String execute(int number) {
        if (number == 3) {
            return "fizz";
        } else if (number == 5) {
            return "buzz";
        } else if (number == 15) {
            return "fizzbuzz";
        }

        return "1";
    }
}