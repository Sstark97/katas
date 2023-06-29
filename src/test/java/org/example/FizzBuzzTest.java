package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import net.jqwik.api.*;

class FizzBuzzTest {
    @Property
    boolean every_element_must_be_fizz(@ForAll("divisible_by_three") int number) {
        return FizzBuzz.execute(number).equals("fizz");
    }

    @Provide
    Arbitrary<Integer> divisible_by_three() {
        return Arbitraries.integers().between(1, 100).filter(number -> number % 3 == 0 && number % 15 != 0);
    }

    @Property
    boolean every_element_must_be_buzz(@ForAll("divisible_by_five") int number) {
        return FizzBuzz.execute(number).equals("buzz");
    }

    @Provide
    Arbitrary<Integer> divisible_by_five() {
        return Arbitraries.integers().between(1, 100).filter(number -> number % 5 == 0 && number % 15 != 0);
    }

    @Property
    boolean every_element_must_be_fizzbuzz(@ForAll("divisible_by_fifteen") int number) {
        return FizzBuzz.execute(number).equals("fizzbuzz");
    }

    @Provide
    Arbitrary<Integer> divisible_by_fifteen() {
        return Arbitraries.integers().between(1, 100).filter(number -> number % 15 == 0);
    }

    @Property
    boolean every_element_must_be_the_same(@ForAll("the_rest_of_numbers") int number) {
        return FizzBuzz.execute(number).equals(Integer.toString(number));
    }

    @Provide
    Arbitrary<Integer> the_rest_of_numbers() {
        return Arbitraries.integers().between(1, 100).filter(number -> number % 3 != 0 && number % 5 != 0);
    }

    @Test
    public void must_be_zero_for_zero () {
        assertEquals("0", FizzBuzz.execute(0));
    }
}