package com.excilys;

/**
 * The type String calculator.
 */
public final class StringCalculator {
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

        return Integer.parseInt(input);
    }
}
