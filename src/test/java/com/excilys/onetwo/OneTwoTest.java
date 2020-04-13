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

    @Test
    public void given1And2_whenDescribe_thenOneOneOneTwo() {
        givenInput_whenDescribe_thenOutput("1 2", "one one one two");
    }

    @Test
    public void given2And2_whenDescribe_thenTwoTwo() {
        givenInput_whenDescribe_thenOutput("2 2", "two two");
    }

    @Test
    public void given399988_whenDescribe_thenOneThreeThreeNineTwoEight() {
        givenInput_whenDescribe_thenOutput("3 9 9 9 8 8", "one three three nine two eight");
    }

    @Test
    public void given1111111_whenDescribe_thenSevenOne() {
        givenInput_whenDescribe_thenOutput("1 1 1 1 1 1 1", "seven one");
    }

    @Test
    public void given244466666_whenDescribe_thenSevenOne() {
        givenInput_whenDescribe_thenOutput("2 4 4 4 6 6 6 6 6", "one two three four five six");
    }
}