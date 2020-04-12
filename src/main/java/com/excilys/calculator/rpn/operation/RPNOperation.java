package com.excilys.calculator.rpn.operation;

import java.util.Deque;

public interface RPNOperation {
    int compute(Deque<Integer> operands);
}
