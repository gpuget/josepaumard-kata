package com.excilys.calculator;

/**
 * Leap year calculator.
 */
public class LeapYearsCalculator {
    private LeapYearsCalculator() {
        throw new AssertionError("RUN AWAAAY !");
    }

    /**
     * Returns if the year is leap. A leap year is defined as one that is divisible by 4, but is not otherwise divisible
     * by 100 unless it is also divisible by 400. For example:
     * <ul>
     *     <li>1996 is typical leap year</li>
     *     <li>2001 is typical common year</li>
     *     <li>1900 is atypical common year</li>
     *     <li>2000 is atypical leap year</li>
     * </ul>
     *
     * @param year
     *         the year
     *
     * @return {@code true} if the year is leap
     */
    public static boolean isLeapYear(int year) {
        return isAtypicalLeap(year) || (!isAtypicalCommon(year) && isTypicalLeap(year));
    }

    /**
     * Returns if the year is common.
     *
     * @param year
     *         the year
     *
     * @return {@code false} if the year is leap
     *
     * @see #isLeapYear(int)
     */
    public static boolean isCommonYear(int year) {
        return !isLeapYear(year);
    }

    /**
     * Returns if a year is a typical leap.
     *
     * @param year
     *         the year
     *
     * @return {@code true} if the year is divisible by 4
     */
    private static boolean isTypicalLeap(int year) {
        return isDivisibleBy(year, 4);
    }

    /**
     * Returns if a year is an atypical common.
     *
     * @param year
     *         the year
     *
     * @return {@code true} if the year is divisible by 100
     */
    private static boolean isAtypicalCommon(int year) {
        return isDivisibleBy(year, 100);
    }

    /**
     * Returns if a year is an atypical leap.
     *
     * @param year
     *         the year
     *
     * @return {@code true} if the year is divisible by 400
     */
    private static boolean isAtypicalLeap(int year) {
        return isDivisibleBy(year, 400);
    }

    private static boolean isDivisibleBy(int number, int by) {
        return (number % by) == 0;
    }
}
