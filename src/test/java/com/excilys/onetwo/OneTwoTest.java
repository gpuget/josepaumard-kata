package com.excilys.onetwo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OneTwoTest {
    private void givenInput_whenDescribe_thenOutput(String input, String output) {
        assertThat(OneTwo.describe(input)).isEqualTo(output);
    }

    @Test
    public void givenEmpty_whenDescribe_thenEmpty() {
        givenInput_whenDescribe_thenOutput("", "");
    }

    @Test
    public void given2_whenDescribe_thenOneTwo() {
        givenInput_whenDescribe_thenOutput("2", "one two");
    }
}