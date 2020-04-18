package com.excilys.calculator.palindrome;

public class PalindromeCalculator {
    private PalindromeCalculator() {
        throw new AssertionError("I am not bad I'm just drawn that way");
    }

    public static boolean isPalindrome(String input) {
        if (input.length() <= 1) {
            return true;
        }
        return false;
    }
}
