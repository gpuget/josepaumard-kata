package com.excilys.calculator;

public class LeapYearsCalculator {
    private LeapYearsCalculator() {
        throw new AssertionError("RUN AWAAAY !");
    }

    public static boolean isLeapYear(int year) {
        return isAtypicalLeap(year) || (!isAtypicalCommon(year) && isTypicalLeap(year));
    }

    private static boolean isTypicalLeap(int number) {
        return isDivisibleBy(number, 4);
    }

    private static boolean isAtypicalCommon(int number) {
        return isDivisibleBy(number, 100);
    }

    private static boolean isAtypicalLeap(int number) {
        return isDivisibleBy(number, 400);
    }

    private static boolean isDivisibleBy(int number, int by) {
        return (number % by) == 0;
    }
}
