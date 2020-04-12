package com.excilys.calculator.rpn.operation;

import java.util.Deque;
import java.util.function.IntBinaryOperator;

/**
 * Binary operation.
 */
public enum BinaryOperation implements RPNOperation {
    /**
     * Add binary operation.
     */
    ADD((x, y) -> x + y),
    /**
     * Sub binary operation.
     */
    SUB((x, y) -> x - y),
    /**
     * Div binary operation.
     */
    DIV((x, y) -> x / y),
    /**
     * Mul binary operation.
     */
    MUL((x, y) -> x * y);

    private final IntBinaryOperator operator;

    BinaryOperation(IntBinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public int compute(Deque<Integer> operands) {
        int tmp = revertAndCompute(operands.pop(), operands.pop());
        operands.push(tmp);
        return tmp;
    }

    private int revertAndCompute(int y, int x) {
        return this.operator.applyAsInt(x, y);
    }
}
