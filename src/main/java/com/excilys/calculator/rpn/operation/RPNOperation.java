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
     *
     * @return the result
     */
    int compute(Deque<Integer> operands);
}
