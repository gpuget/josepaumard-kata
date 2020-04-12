package com.excilys.calculator.rpn;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

public enum Operation {
    ADD((x, y) -> x + y),
    SUB((x, y) -> x - y),
    MUL((x, y) -> x * y),
    DIV((x, y) -> x / y),
    SQRT((x, y) -> (int) Math.sqrt(x)) {
        @Override
        public int reverseAndCompute(int y, int x) {
            return compute(y, x);
        }
    },
    MAX(null);

    private static final Map<String, Operation> MAPPING =
            Map.of("+", ADD, "/", DIV, ":", DIV, "-", SUB, "*", MUL, "x", MUL, SQRT.name(), SQRT, MAX.name(), MAX);

    private final IntBinaryOperator op;

    Operation(IntBinaryOperator op) {
        this.op = op;
    }

    public static Operation of(String symbol) {
        return Optional.ofNullable(MAPPING.get(symbol))
                       .orElseThrow(() -> new IllegalArgumentException("no operation for symbol: " + symbol));
    }

    public int compute(int x, int y) {
        return this.op.applyAsInt(x, y);
    }

    public int reverseAndCompute(int y, int x) {
        return compute(x, y);
    }
}
