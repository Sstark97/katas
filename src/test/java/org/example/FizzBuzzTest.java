package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import net.jqwik.api.*;

class FizzBuzzTest {
    @Property
    boolean every_element_must_be_fizz(@ForAll("divisible_by_three") int i) {
        return FizzBuzz.execute(i).equals("fizz");
    }

    @Provide
    Arbitrary<Integer> divisible_by_three() {
        return Arbitraries.integers().between(1, 100).filter(i -> i % 3 == 0 && i % 15 != 0);
    }

    @Property
    boolean every_element_must_be_buzz(@ForAll("divisible_by_five") int i) {
        return FizzBuzz.execute(i).equals("buzz");
    }

    @Provide
    Arbitrary<Integer> divisible_by_five() {
        return Arbitraries.integers().between(1, 100).filter(i -> i % 5 == 0 && i % 15 != 0);
    }

    @Property
    boolean every_element_must_be_fizzbuzz(@ForAll("divisible_by_fifteen") int i) {
        return FizzBuzz.execute(i).equals("fizzbuzz");
    }

    @Provide
    Arbitrary<Integer> divisible_by_fifteen() {
        return Arbitraries.integers().between(1, 100).filter(i -> i % 15 == 0);
    }

    @Property
    boolean every_element_must_be_the_same(@ForAll("the_rest_of_numbers") int i) {
        return FizzBuzz.execute(i).equals(Integer.toString(i));
    }

    @Provide
    Arbitrary<Integer> the_rest_of_numbers() {
        return Arbitraries.integers().between(1, 100).filter(i -> i % 3 != 0 && i % 5 != 0);
    }

    @Test
    public void must_be_zero_for_zero () {
        assertEquals("0", FizzBuzz.execute(0));
    }
}