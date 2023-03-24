package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {
    @Test
    void number_one_should_return_I() {
        assertEquals(RomanNumerals.transform(1), "I");
    }

    @Test
    void number_one_should_return_II() {
        assertEquals(RomanNumerals.transform(2), "II");
    }

    @Test
    void number_one_should_return_III() {
        assertEquals(RomanNumerals.transform(3), "III");
    }

    @Test
    void number_one_should_return_IV() {
        assertEquals(RomanNumerals.transform(4), "IV");
    }
}