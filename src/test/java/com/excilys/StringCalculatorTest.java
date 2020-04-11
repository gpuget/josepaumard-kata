package com.excilys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.ToIntFunction;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @Test
    public void empty() {
        TestBuilder.given("").when(StringCalculator::add).then(0);
    }

    @Test
    public void simple() {
        TestBuilder.given("1").when(StringCalculator::add).then(1);
    }

    @Test
    public void twoArguments() {
        TestBuilder.given("1,2").when(StringCalculator::add).then(3);
    }

    @Test
    public void multiple() {
        TestBuilder.given("1,2,3,4,5,6").when(StringCalculator::add).then(21);
    }

    @Test
    public void newLine() {
        TestBuilder.given("1\n2,3,").when(StringCalculator::add).then(6);
    }

    @Test
    public void newLineAtThenEnd() {
        TestBuilder.given("1,\n").when(StringCalculator::add).thenThrows(IllegalArgumentException.class);
    }

    @Test
    public void delimiter() {
        TestBuilder.given("//;\n1;2").when(StringCalculator::add).then(3);
    }

    @Test
    public void negative() {
        TestBuilder.given("1,-2,-3")
                   .when(StringCalculator::add)
                   .thenThrows(IllegalArgumentException.class)
                   .andMessageContains("-2", "-3");
    }

    @Test
    public void max() {
        TestBuilder.given("2,1000").when(StringCalculator::add).then(1002);
    }

    @Test
    public void over9000() {
        TestBuilder.given("1,9000").when(StringCalculator::add).then(1);
    }

    private static class TestBuilder {
        private final String input;
        private ToIntFunction<String> method;
        private Exception exception;

        private TestBuilder(String input) {
            this.input = input;
        }

        private static TestBuilder given(String input) {
            return new TestBuilder(input);
        }

        private TestBuilder when(ToIntFunction<String> method) {
            this.method = method;
            return this;
        }

        private int execute() {
            return this.method.applyAsInt(this.input);
        }

        private void then(int result) {
            assertThat(execute()).isEqualTo(result);
        }

        private TestBuilder thenThrows(Class<? extends Exception> e) {
            this.exception = assertThrows(e, this::execute);
            return this;
        }

        private void andMessageContains(String... expected) {
            assertThat(this.exception.getMessage()).contains(expected);
        }
    }
}