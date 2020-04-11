package com.excilys;

import java.util.stream.Stream;

/**
 * The type String calculator.
 */
public final class StringCalculator {
    private static final String DELIMITER = ",";

    private StringCalculator() {
        throw new AssertionError();
    }

    /**
     * Add int.
     *
     * @param input
     *         the input
     *
     * @return the int
     */
    public static int add(String input) {
        if (input.isBlank()) {
            return 0;
        }

        return Stream.of(input.split(DELIMITER)).mapToInt(Integer::parseInt).sum();
    }
}
