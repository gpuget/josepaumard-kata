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

class RPNCollector implements Collector<String, Deque<Integer>, Integer> {
    private final Deque<Integer> operands = new ArrayDeque<>(2);

    @Override
    public Supplier<Deque<Integer>> supplier() {
        return () -> this.operands;
    }

    @Override
    public BiConsumer<Deque<Integer>, String> accumulator() {
        return (opAcc, s) -> opAcc.push(consume(s));
    }

    private Integer consume(String s) {
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
