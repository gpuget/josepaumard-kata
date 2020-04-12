package com.excilys.calculator.rpn;

import java.util.regex.Pattern;

public class RPNCalculator {
    private static final Pattern DELIMITER = Pattern.compile(" ");

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

        return doCompute(input);
    }

    private static int doCompute(String input) {
        var split = DELIMITER.split(input);
        if (split.length == 3) {
            return Operation.of(split[2]).compute(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            throw new IllegalArgumentException("impossible to compile the operation");
        }
    }
}
