package com.excilys.calculator;

public class LeapYearsCalculator {
    private LeapYearsCalculator() {
        throw new AssertionError("RUN AWAAAY !");
    }

    public static boolean execute(int year) {
        return isDivisibleBy4(year) && !isDivisibleBy100(year);
    }

    private static boolean isDivisibleBy4(int number) {
        return isDivisibleBy(number, 4);
    }

    private static boolean isDivisibleBy100(int number) {
        return isDivisibleBy(number, 100);
    }

    private static boolean isDivisibleBy(int number, int by) {
        return (number % by) == 0;
    }
}
