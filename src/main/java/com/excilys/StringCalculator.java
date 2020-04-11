package com.excilys;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * The type String calculator.
 */
public final class StringCalculator {
    private static final String DELIMITER = "[,\\n]";

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

        if (Pattern.matches("\\d*" + DELIMITER + '+', input)) {
            throw new IllegalArgumentException("missing number");
        }

        return Stream.of(input.split(DELIMITER)).mapToInt(Integer::parseInt).sum();
    }
}
