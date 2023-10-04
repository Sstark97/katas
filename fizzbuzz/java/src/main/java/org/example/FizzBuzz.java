package org.example;

public class FizzBuzz {
    public static String execute(int number) {
        if(number == 0) {
            return "0";
        }
        boolean isDivisibleByThree = number % 3 == 0;
        boolean isDivisibleByFive = number % 5 == 0;

        if (isDivisibleByThree && isDivisibleByFive) {
            return "fizzbuzz";
        } else if (isDivisibleByThree) {
            return "fizz";
        } else if (isDivisibleByFive) {
            return "buzz";

        }

        return Integer.toString(number);
    }
}