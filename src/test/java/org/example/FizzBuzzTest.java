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
}