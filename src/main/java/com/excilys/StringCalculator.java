package com.excilys;

import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The type String calculator.
 */
public final class StringCalculator {
    private static final String DEFAULT_NUMBER_DELIMITER = "[,\\n]";
    private static final String DELIMITER_PREFIX = "//";
    private static final String DELILITER_DELIMITER = "\\n";
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

        String delimiter;
        String values;
        if (input.startsWith(DELIMITER_PREFIX)) {
            var split = input.substring(DELIMITER_PREFIX.length()).split(DELILITER_DELIMITER, 2);
            delimiter = split[0];
            values = split[1];
        } else {
            delimiter = DEFAULT_NUMBER_DELIMITER;
            values = input;
        }

        if (input.endsWith("\n")) {
            throw new IllegalArgumentException("missing number");
        }

        Supplier<IntStream> numbers =
                () -> Pattern.compile(delimiter).splitAsStream(values).mapToInt(Integer::parseInt);
        String negativeNumbers =
                numbers.get().filter(i -> i < 0).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("not allowed negative number: " + negativeNumbers);
        }

        return numbers.get().filter(i -> i < MAX).sum();
    }
}
