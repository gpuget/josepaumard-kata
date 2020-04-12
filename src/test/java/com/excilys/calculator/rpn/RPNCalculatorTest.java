package com.excilys.calculator.rpn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RPNCalculatorTest {
    private void givenInput_whenCompute_thenExpected(String input, int expected) {
        assertThat(RPNCalculator.compute(input)).isEqualTo(expected);
    }

    @Test
    public void givenEmpty_whenCompute_then0() {
        givenInput_whenCompute_thenExpected("", 0);
    }
}