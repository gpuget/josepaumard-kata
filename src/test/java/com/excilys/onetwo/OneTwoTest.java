package com.excilys.onetwo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OneTwoTest {
    private void givenInput_whenRead_thenOutput(String input, String output) {
        assertThat(OneTwo.read(input)).isEqualTo(output);
    }

    private void givenInput_whenWrite_thenOutput(String input, String output) {
        assertThat(OneTwo.write(input)).isEqualTo(output);
    }

    @Test
    public void givenEmpty_whenRead_thenEmpty() {
        givenInput_whenRead_thenOutput("", "");
    }

    @Test
    public void given2_whenRead_thenOneTwo() {
        givenInput_whenRead_thenOutput("2", "one two");
    }

    @Test
    public void given1And2_whenRead_thenOneOneOneTwo() {
        givenInput_whenRead_thenOutput("1 2", "one one one two");
    }

    @Test
    public void given2And2_whenRead_thenTwoTwo() {
        givenInput_whenRead_thenOutput("2 2", "two two");
    }

    @Test
    public void given399988_whenRead_thenOneThreeThreeNineTwoEight() {
        givenInput_whenRead_thenOutput("3 9 9 9 8 8", "one three three nine two eight");
    }

    @Test
    public void given1111111_whenRead_thenSevenOne() {
        givenInput_whenRead_thenOutput("1 1 1 1 1 1 1", "seven one");
    }

    @Test
    public void given244466666_whenRead_thenOneTwoThreeFourFive() {
        givenInput_whenRead_thenOutput("2 4 4 4 6 6 6 6 6", "one two three four five six");
    }

    @Test
    public void given555555555555_whenRead_thenNineFiveThreeFive() {
        givenInput_whenRead_thenOutput("5 5 5 5 5 5 5 5 5 5 5 5", "nine five three five");
    }

    @Test
    public void givenEmpty_whenWrite_thenEmpty() {
        givenInput_whenWrite_thenOutput("", "");
    }

    @Test
    public void givenOneTwo_whenWrite_then2() {
        givenInput_whenWrite_thenOutput("one two", "2");
    }

    @Test
    public void givenOneOneOneTwo_whenWrite_then12() {
        givenInput_whenWrite_thenOutput("one one one two", "1 2");
    }

    @Test
    public void givenTwoTwo_whenWrite_then22() {
        givenInput_whenWrite_thenOutput("two two", "2 2");
    }

    @Test
    public void givenOneThreeThreeNineTwoEight_whenWrite_then399988() {
        givenInput_whenWrite_thenOutput("one three three nine two eight", "3 9 9 9 8 8");
    }

    @Test
    public void givenOneTwoThreeFourFiveSix_whenWrite_then244466666() {
        givenInput_whenWrite_thenOutput("one two three four five six", "2 4 4 4 6 6 6 6 6");
    }

    @Test
    public void givenNineFiveThreeFive_whenWrite_then555555555555() {
        givenInput_whenWrite_thenOutput("nine five three five", "5 5 5 5 5 5 5 5 5 5 5 5");
    }
}