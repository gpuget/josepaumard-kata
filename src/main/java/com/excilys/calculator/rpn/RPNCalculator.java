package com.excilys.calculator.rpn;

import java.util.ArrayDeque;
import java.util.Deque;
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
        Deque<Integer> operands = new ArrayDeque<>(2);

        for (String s : DELIMITER.split(input)) {
            if (Character.isDigit(s.charAt(0))) {
                operands.push(Integer.parseInt(s));
            } else {
                int intermediate = Operation.of(s).reverseAndCompute(operands.pop(), operands.pop());
                operands.push(intermediate);
            }
        }

        return operands.pop();
    }
}
