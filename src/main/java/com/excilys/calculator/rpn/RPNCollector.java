package com.excilys.calculator.rpn;

import com.excilys.calculator.rpn.operation.RPNOperationStrategy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * RPN Collector.
 */
enum RPNCollector implements Collector<String, Deque<Integer>, Integer> {
    /**
     * Singleton instance.
     */
    INSTANCE;

    private final Deque<Integer> operands = new ArrayDeque<>(2);

    /**
     * Gets the instance of RPN collector.
     *
     * @return the instance
     */
    public static RPNCollector get() {
        return INSTANCE;
    }

    @Override
    public Supplier<Deque<Integer>> supplier() {
        return () -> this.operands;
    }

    @Override
    public BiConsumer<Deque<Integer>, String> accumulator() {
        return (opAcc, s) -> opAcc.push(mapToInteger(s));
    }

    private Integer mapToInteger(String s) {
        return Character.isDigit(s.charAt(0))
               ? Integer.parseInt(s)
               : RPNOperationStrategy.of(s).compute(this.operands);
    }

    @Override
    public BinaryOperator<Deque<Integer>> combiner() {
        return (opAcc, opAcc2) -> opAcc;
    }

    @Override
    public Function<Deque<Integer>, Integer> finisher() {
        return Deque::pop;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
