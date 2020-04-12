package com.excilys.calculator.rpn.operation;

import static com.excilys.calculator.rpn.operation.AggregationOperation.MAX;
import static com.excilys.calculator.rpn.operation.BinaryOperation.ADD;
import static com.excilys.calculator.rpn.operation.BinaryOperation.DIV;
import static com.excilys.calculator.rpn.operation.BinaryOperation.MUL;
import static com.excilys.calculator.rpn.operation.BinaryOperation.SUB;
import static com.excilys.calculator.rpn.operation.UnaryOperation.SQRT;

import java.util.Map;
import java.util.Optional;

public class RPNOperationStrategy {
    private static final Map<String, RPNOperation> MAPPING =
            Map.of("+", ADD, "/", DIV, ":", DIV, "-", SUB, "*", MUL, "x", MUL, SQRT.name(), SQRT, MAX.name(), MAX);

    private RPNOperationStrategy() {
        throw new AssertionError("Never call me, please");
    }

    public static RPNOperation of(String symbol) {
        return Optional.ofNullable(MAPPING.get(symbol))
                       .orElseThrow(() -> new IllegalArgumentException("no operation found for: " + symbol));
    }
}
