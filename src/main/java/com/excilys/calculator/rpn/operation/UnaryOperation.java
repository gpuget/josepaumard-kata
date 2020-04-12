package com.excilys.calculator.rpn.operation;

import java.util.Deque;
import java.util.function.IntUnaryOperator;

/**
 * Unary operation.
 */
public enum UnaryOperation implements RPNOperation {
    /**
     * Square root operation.
     */
    SQRT(i -> (int) Math.sqrt(i));

    private final IntUnaryOperator operator;

    UnaryOperation(IntUnaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public int compute(Deque<Integer> operands) {
        return this.operator.applyAsInt(operands.pop());
    }
}
