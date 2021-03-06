package com.excilys.calculator.rpn.operation;

import java.util.Deque;
import java.util.OptionalInt;
import java.util.function.Function;

/**
 * Aggregation operation.
 */
public enum AggregationOperation implements RPNOperation {
    /**
     * Max aggregation operation.
     */
    MAX(deque -> deque.stream().mapToInt(Integer::intValue).max());

    private final Function<Deque<Integer>, OptionalInt> operator;

    AggregationOperation(Function<Deque<Integer>, OptionalInt> operator) {
        this.operator = operator;
    }

    @Override
    public int compute(Deque<Integer> operands) {
        int tmp = this.operator.apply(operands).orElseThrow(() -> new IllegalArgumentException("missing operands"));
        operands.removeAll(operands);
        return tmp;
    }
}
