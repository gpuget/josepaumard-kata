package com.excilys.calculator.palindrome;

public class PalindromeCalculator {
    private PalindromeCalculator() {
        throw new AssertionError("I am not bad I'm just drawn that way");
    }

    public static boolean isPalindrome(String input) {
        int length = input.length();
        if (length <= 1) {
            return true;
        } else if (length == 2) {
            return input.charAt(0) == input.charAt(length - 1);
        }

        return false;
    }
}
