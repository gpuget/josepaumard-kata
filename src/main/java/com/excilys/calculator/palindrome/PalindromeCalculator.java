package com.excilys.calculator.palindrome;

import java.util.Objects;

public class PalindromeCalculator {
    private PalindromeCalculator() {
        throw new AssertionError("I am not bad I'm just drawn that way");
    }

    public static boolean isPalindrome(String input) {
        int length = input.length();
        if (length <= 1) {
            return true;
        }

        return whileSolution(input.replace(".", ""));
    }

    private static boolean whileSolution(String input) {
        int first = 0;
        int last = input.length() - 1;

        while (first < last) {
            if (!Objects.equals(Character.toLowerCase(Character.toLowerCase(input.charAt(first))),
                                Character.toLowerCase(input.charAt(last)))) {
                return false;
            }

            first++;
            last--;
        }

        return true;
    }

    private static boolean stringBuilderSolution(String input) {
        String lower = input.toLowerCase();
        return new StringBuilder(lower).reverse().toString().equals(lower);
    }
}
