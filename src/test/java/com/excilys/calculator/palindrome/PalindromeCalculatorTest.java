package com.excilys.calculator.palindrome;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class PalindromeCalculatorTest {
    private void givenInput_thenIsPalindrome(String input) {
        assertThat(PalindromeCalculator.isPalindrome(input)).isTrue();
    }

    @Test
    public void givenEmpty_thenIsPalindrome() {
        givenInput_thenIsPalindrome("");
    }

    @Test
    public void given1Char_thenIsPalindrome() {
        givenInput_thenIsPalindrome("D");
    }

    @Test
    public void given2Char_thenIsPalindrome() {
        givenInput_thenIsPalindrome("DD");
    }

    @Test
    public void given3Char_thenIsPalindrome() {
        givenInput_thenIsPalindrome("Dad");
        givenInput_thenIsPalindrome("Mum");
        givenInput_thenIsPalindrome("Eve");
    }

    @Test
    public void givenWords_thenIsPalindrome() {
        Stream.of("level", "radar", "rotor", "reviver", "redivider").forEach(this::givenInput_thenIsPalindrome);
    }
}