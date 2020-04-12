package com.excilys.calculator.rpn;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

/**
 * Enum of all operations
 */
public enum Operation {
    /**
     * Addition operation.
     */
    ADD((x, y) -> x + y),
    /**
     * Subtraction operation.
     */
    SUB((x, y) -> x - y),
    /**
     * Multiplication operation.
     */
    MUL((x, y) -> x * y),
    /**
     * Division operation.
     */
    DIV((x, y) -> x / y),
    /**
     * Square root operation.
     */
    SQRT((x, y) -> (int) Math.sqrt(x)) {
        @Override
        public int revertAndCompute(int y, int x) {
            return compute(y, x);
        }
    },
    /**
     * Max operation.
     */
    MAX(null);

    private static final Map<String, Operation> MAPPING =
            Map.of("+", ADD, "/", DIV, ":", DIV, "-", SUB, "*", MUL, "x", MUL, SQRT.name(), SQRT, MAX.name(), MAX);

    private final IntBinaryOperator op;

    Operation(IntBinaryOperator op) {
        this.op = op;
    }

    /**
     * Gets the operation corresponding to the symbol.
     *
     * @param symbol
     *         the symbol
     *
     * @return the operation
     *
     * @throws IllegalArgumentException
     *         if no operation found
     */
    public static Operation of(String symbol) {
        return Optional.ofNullable(MAPPING.get(symbol))
                       .orElseThrow(() -> new IllegalArgumentException("no operation for symbol: " + symbol));
    }

    /**
     * Computes the operation.
     *
     * @param x
     *         the first operand
     * @param y
     *         the second operand
     *
     * @return the result
     */
    public int compute(int x, int y) {
        return this.op.applyAsInt(x, y);
    }

    /**
     * Reverts operands and computes operation.
     *
     * @param y
     *         the second operand
     * @param x
     *         the first operand
     *
     * @return the result
     */
    public int revertAndCompute(int y, int x) {
        return compute(x, y);
    }
}
