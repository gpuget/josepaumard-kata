package com.excilys;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @Test
    public void empty() {
        assertThat(StringCalculator.add("")).isZero();
    }
}