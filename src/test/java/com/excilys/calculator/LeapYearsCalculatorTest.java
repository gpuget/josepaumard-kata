package com.excilys.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LeapYearsCalculatorTest {
    private void givenYear_whenLeapYear_then(int year, boolean leap) {
        assertThat(LeapYearsCalculator.isLeapYear(year)).isEqualTo(leap);
    }

    private void givenYear_whenLeapYear_thenCommon(int year) {
        givenYear_whenLeapYear_then(year, false);
    }

    private void givenYear_whenLeapYear_thenLeap(int year) {
        givenYear_whenLeapYear_then(year, true);
    }

    @Test
    public void given2001_whenLeapYear_thenCommon() {
        givenYear_whenLeapYear_thenCommon(2001);
    }

    @Test
    public void given1996_whenLeapYear_thenLeap() {
        givenYear_whenLeapYear_thenLeap(1996);
    }

    @Test
    public void given1900_whenLeapYear_thenCommon() {
        givenYear_whenLeapYear_thenCommon(1900);
    }

    @Test
    public void given2000_whenLeapYear_thenLeap() {
        givenYear_whenLeapYear_thenLeap(2000);
    }

    @Test
    public void givenYear_whenCommonYear_thenNotLeap() {
        boolean expected = !LeapYearsCalculator.isLeapYear(2000);
        assertThat(LeapYearsCalculator.isCommonYear(2000)).isEqualTo(expected);
    }
}