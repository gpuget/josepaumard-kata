package com.excilys.calculator.rpn.operation;

import java.util.Deque;
import java.util.function.IntBinaryOperator;

public enum BinaryOperation implements RPNOperation {
    ADD((x, y) -> x + y),
    SUB((x, y) -> x - y),
    DIV((x, y) -> x / y),
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
