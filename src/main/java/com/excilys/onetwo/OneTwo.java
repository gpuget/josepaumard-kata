package com.excilys.onetwo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * OneTwo string describer.
 */
public class OneTwo {
    private static final Map<Integer, String> TO_LETTER =
            Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five", 6, "six", 7, "seven", 8, "eight", 9, "nine");
    private static final Map<String, Integer> TO_DIGIT;
    private static final String DELIMITER = " ";

    static {
        TO_DIGIT = Collections.unmodifiableMap(
                TO_LETTER.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)));
    }

    private OneTwo() {
        throw new AssertionError("You shall not pass !");
    }

    /**
     * Reads the input and returns an understandable string.
     *
     * @param input
     *         the input
     *
     * @return the understandable string
     */
    public static String read(String input) {
        if (input.isBlank()) {
            return input;
        }

        StringJoiner joiner = new StringJoiner(DELIMITER);
        Pattern.compile(DELIMITER)
               .splitAsStream(input)
               .collect(Collectors.groupingBy(s -> TO_LETTER.get(Integer.parseInt(s)), LinkedHashMap::new,
                                              Collectors.toList()))
               .forEach((s, list) -> doRead(joiner, s, list));
        return joiner.toString();
    }

    private static void doRead(StringJoiner joiner, String key, List<String> values) {
        int limit = TO_LETTER.size();
        int number = values.size();
        if (values.size() > TO_LETTER.size()) {
            joiner.add(TO_LETTER.get(limit)).add(key);
            number -= limit;
        }
        joiner.add(TO_LETTER.get(number)).add(key);
    }

    public static String write(String input) {
        if (input.isBlank()) {
            return input;
        }

        Deque<String> deque = new ArrayDeque<>(Arrays.asList(input.split(DELIMITER)));
        StringJoiner joiner = new StringJoiner(DELIMITER);
        do {
            joiner.add(doWrite(deque.pollFirst(), deque.pollFirst()));
        } while (!deque.isEmpty());
        return joiner.toString();
    }

    private static String doWrite(String number, String value) {
        return Stream.generate(() -> TO_DIGIT.get(value))
                     .limit(TO_DIGIT.get(number))
                     .map(String::valueOf)
                     .collect(Collectors.joining(DELIMITER));
    }
}
