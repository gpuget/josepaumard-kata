package com.excilys.calculator.rpn;

public class RPNCalculator {
    private RPNCalculator() {
        throw new AssertionError("The choice is an illusion");
    }

    public static int compute(String input) {
        if (input.isBlank()) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        return 0;
    }
}
