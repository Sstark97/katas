package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    public void must_be_one_for_number_one () {
        assertEquals("1", FizzBuzz.execute(1));
    }

    @Test
    public void must_be_fizz_for_number_three () {
        assertEquals("fizz", FizzBuzz.execute(3));
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
    public void must_be_fizz_for_any_number_divisible_by_three () {
        assertEquals("fizz", FizzBuzz.execute(6));
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