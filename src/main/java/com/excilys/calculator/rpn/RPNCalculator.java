package com.excilys.calculator.rpn;

public class RPNCalculator {
    private static final String DELIMITER = " ";

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

        var split = input.split(DELIMITER);
        if (split.length == 3) {
            return Operation.of(split[2]).compute(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        return 0;
    }
}
