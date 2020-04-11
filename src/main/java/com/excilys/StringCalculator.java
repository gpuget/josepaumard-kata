package com.excilys;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * The type String calculator.
 */
public final class StringCalculator {
    private static final String DEFAULT_NUMBER_DELIMITER = "[,\\n]";
    private static final String DELIMITER_PREFIX = "//";
    private static final String DELILITER_DELIMITER = "\\n";

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

        String delimiter = DEFAULT_NUMBER_DELIMITER;
        if (input.startsWith(DELIMITER_PREFIX)) {
            var split = input.substring(DELIMITER_PREFIX.length()).split(DELILITER_DELIMITER, 2);
            delimiter = split[0];
            input = split[1];
        }

        if (Pattern.matches("\\d*" + delimiter + '+', input)) {
            throw new IllegalArgumentException("missing number");
        }

        return Stream.of(input.split(delimiter)).mapToInt(Integer::parseInt).sum();
    }
}
