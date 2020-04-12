package com.excilys.calculator.rpn.operation;

import java.util.Deque;

/**
 * RPN Operation.
 */
@FunctionalInterface
public interface RPNOperation {
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
