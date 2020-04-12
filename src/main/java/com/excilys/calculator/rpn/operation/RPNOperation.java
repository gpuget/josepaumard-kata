package com.excilys.calculator.rpn.operation;

import java.util.Deque;

/**
 * RPN Operation.
 */
public interface RPNOperation {
    /**
     * Computes with all operands and pushes the result in the {@link Deque}.
     *
     * @param operands
     *         the operands
     */
    default void computeAndPush(Deque<Integer> operands) {
        operands.push(compute(operands));
    }

    /**
     * Computes with all operands.
     *
     * @param operands
     *         the operands
     *
     * @return the result
     */
    int compute(Deque<Integer> operands);
}
