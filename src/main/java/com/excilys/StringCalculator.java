package com.excilys;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type String calculator.
 */
public final class StringCalculator {
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("\\n");
    private static final String DEFAULT_NUMBER_DELIMITER = "[,\\n]";
    private static final String DELIMITER_PREFIX = "//";
    private static final int MAX = 1000;

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
        if (hasCustomDelimiter(input)) {
            var split = DELIMITER_PATTERN.split(input.substring(DELIMITER_PREFIX.length()), 2);
            delimiter = split[0];
            input = split[1];
        }

        return add(input, delimiter);
    }

    private static int add(String input, String delimiter) {
        check(input, delimiter);
        return asIntStream(input, delimiter).filter(i -> i < MAX).sum();
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(DELIMITER_PREFIX);
    }

    public static void check(String input, String delimiter) {
        checkFormat(input);
        checkNoNegativeNumber(input, delimiter);
    }

    private static void checkFormat(String input) {
        if (input.endsWith("\n")) {
            throw new IllegalArgumentException("missing number");
        }
    }

    private static void checkNoNegativeNumber(String input, String delimiter) {
        String negativeNumbers = asIntStream(input, delimiter).filter(i -> i < 0)
                                                              .mapToObj(String::valueOf)
                                                              .collect(Collectors.joining(", "));
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("not allowed negative number: " + negativeNumbers);
        }
    }

    private static IntStream asIntStream(String input, String delimiter) {
        return Pattern.compile(delimiter).splitAsStream(input).mapToInt(Integer::parseInt);
    }
}
