package com.excilys.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LeapYearsCalculatorTest {
    private void givenYear_whenLeapYears_then(int year, boolean leap) {
        assertThat(LeapYearsCalculator.execute(year)).isEqualTo(leap);
    }

    private void givenYear_whenLeapYears_thenCommon(int year) {
        givenYear_whenLeapYears_then(year, false);
    }

    private void givenYear_whenLeapYears_thenLeap(int year) {
        givenYear_whenLeapYears_then(year, true);
    }

    @Test
    public void given2001_whenLeapYears_thenCommon() {
        givenYear_whenLeapYears_thenCommon(2001);
    }

    @Test
    public void given1996_whenLeapYears_thenLeap() {
        givenYear_whenLeapYears_thenLeap(1996);
    }

    @Test
    public void given1900_whenLeapYears_thenCommon() {
        givenYear_whenLeapYears_thenCommon(1900);
    }

    @Test
    public void given2000_whenLeapYears_thenLeap() {
        givenYear_whenLeapYears_thenLeap(2000);
    }
}