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

    @Test
    public void given20And5AndDivision_whenCompute_then4() {
        givenInput_whenCompute_thenExpected("20 5 /", 4);
        givenInput_whenCompute_thenExpected("20 5 :", 4);
    }

    @Test
    public void given4And2AndAdditionAnd3AndSubtract_whenCompute_then3() {
        givenInput_whenCompute_thenExpected("4 2 + 3 -", 3);
    }

    @Test
    public void given3And5And8AndMultiplicationAnd7AndAdditionAndMultiplication_whenCompute_then141() {
        givenInput_whenCompute_thenExpected("3 5 8 * 7 + *", 141);
    }

    @Test
    public void given9AndSqrt_whenCompute_then3() {
        givenInput_whenCompute_thenExpected("9 SQRT", 3);
    }

    @Test
    public void givenMax_whenCompute_thenMax() {
        givenInput_whenCompute_thenExpected("5 8 1 4 2 MAX", 8);
    }
}