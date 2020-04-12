package com.excilys.calculator.rpn.operation;

import java.util.Deque;
import java.util.function.IntUnaryOperator;

public enum UnaryOperation implements RPNOperation {
    SQRT(i -> (int) Math.sqrt(i));

    private final IntUnaryOperator operator;

    UnaryOperation(IntUnaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public int compute(Deque<Integer> operands) {
        int tmp = this.operator.applyAsInt(operands.pop());
        operands.push(tmp);
        return tmp;
    }
}
