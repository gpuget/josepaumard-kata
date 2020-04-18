package com.excilys.calculator.palindrome;

import static org.assertj.core.api.Assertions.assertThat;

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
}