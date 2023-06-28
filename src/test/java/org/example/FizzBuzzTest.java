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

    @Test
    public void must_be_one_for_number_one () {
        assertEquals("1", FizzBuzz.execute(1));
    }

    @Test
    public void must_be_buzz_for_number_five () {
        assertEquals("buzz", FizzBuzz.execute(5));
    }

    @Test
    public void must_be_fizzbuzz_for_number_fifteen () {
        assertEquals("fizzbuzz", FizzBuzz.execute(15));
    }

    @Test
    public void must_be_buzz_for_any_number_divisible_by_five () {
        assertEquals("buzz", FizzBuzz.execute(10));
    }

    @Test
    public void must_be_buzz_for_any_number_divisible_by_fifteen () {
        assertEquals("fizzbuzz", FizzBuzz.execute(30));
    }

    @Test
    public void must_be_the_same_number_for_the_rest () {
        assertEquals("2", FizzBuzz.execute(2));
    }

    @Test
    public void must_be_zero_for_zero () {
        assertEquals("0", FizzBuzz.execute(0));
    }
}