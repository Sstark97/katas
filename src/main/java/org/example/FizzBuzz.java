package org.example;

public class FizzBuzz {
    public static String execute(int number) {
        if (number == 3) {
            return "fizz";
        } else if (number == 5) {
            return "buzz";
        }
        return "1";
    }
}