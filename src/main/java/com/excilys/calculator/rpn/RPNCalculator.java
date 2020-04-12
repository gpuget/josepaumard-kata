package com.excilys.calculator.rpn;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.regex.Pattern;

/**
 * A RPN calculator program computes expressions written in RPN (Reverse Polish Notation). A RPN expression (or a
 * postfix expression) is one of the following:
 * <ul>
 *     <li>a number X, in which case the value of the expression is that of X; </li>
 *     <li>a sequence of the form E1 E2 O, where E1 and E2 are postfix expressions and O is an arithmetic operation;</li>
 * </ul>
 * In this case, the value of the expression is that of E1 O E2.
 */
public class RPNCalculator {
    private static final Pattern DELIMITER = Pattern.compile(" ");

    private RPNCalculator() {
        throw new AssertionError("The choice is an illusion");
    }

    /**
     * Reads the input and performs operations.
     *
     * @param input
     *         the input
     *
     * @return the result
     */
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
                Operation operation = Operation.of(s);
                if (operation == Operation.SQRT) {
                    operands.push(operation.compute(operands.pop(), 0));
                } else if (operation == Operation.MAX) {
                    return operands.stream()
                                   .max(Comparator.naturalOrder())
                                   .orElseThrow(() -> new IllegalArgumentException("missing operand"));
                } else {
                    int intermediate = operation.revertAndCompute(operands.pop(), operands.pop());
                    operands.push(intermediate);
                }
            }
        }

        return operands.pop();
    }
}
