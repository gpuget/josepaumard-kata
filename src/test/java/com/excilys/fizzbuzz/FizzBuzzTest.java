package com.excilys.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {
    @Test
    public void given1_whenFizzBuzz_then1() {
        givenNumber_whenFizzBuzz_thenExpected(1, "1");
    }

    @Test
    public void given3_whenFizzBuzz_thenFizz() {
        givenNumber_whenFizzBuzz_thenExpected(3, "Fizz");
    }

    private void givenNumber_whenFizzBuzz_thenExpected(int number, String expected) {
        assertThat(FizzBuzz.execute(number)).isEqualTo(expected);
    }
}