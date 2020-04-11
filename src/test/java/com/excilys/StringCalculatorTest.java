package com.excilys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @Test
    public void empty() {
        String input = "";
        assertThat(StringCalculator.add(input)).isZero();
    }

    @Test
    public void simple() {
        String input = "1";
        assertThat(StringCalculator.add(input)).isEqualTo(1);
    }

    @Test
    public void twoArguments() {
        String input = "1,2";
        assertThat(StringCalculator.add(input)).isEqualTo(3);
    }

    @Test
    public void multiple() {
        String input = "1,2,3,4,5,6";
        assertThat(StringCalculator.add(input)).isEqualTo(21);
    }

    @Test
    public void newLine() {
        String input = "1\n2,3,";
        assertThat(StringCalculator.add(input)).isEqualTo(6);
    }

    @Test
    public void newLineAtThenEnd() {
        String input = "1,\n";
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add(input));
    }
}