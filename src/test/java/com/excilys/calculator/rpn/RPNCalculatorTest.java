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

    @Test
    public void given1_whenCompute_then1() {
        givenInput_whenCompute_thenExpected("1", 1);
    }

    @Test
    public void given1And2AndAddition_whenCompute_then3() {
        givenInput_whenCompute_thenExpected("1 2 +", 3);
    }
}