package com.excilys.calculator.rpn;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

public enum Operation {
    ADD((x, y) -> x + y),
    DIVIDE((x, y) -> x / y);

    private static final Map<String, Operation> MAPPING = Map.of("+", ADD, "/", DIVIDE, ":", DIVIDE);

    private final IntBinaryOperator op;

    Operation(IntBinaryOperator op) {
        this.op = op;
    }

    public static Operation of(String symbol) {
        return Optional.ofNullable(MAPPING.get(symbol)).orElseThrow(IllegalAccessError::new);
    }

    public int compute(int x, int y) {
        return this.op.applyAsInt(x, y);
    }
}
