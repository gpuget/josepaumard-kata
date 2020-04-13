package com.excilys.onetwo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * OneTwo string describer.
 */
public class OneTwo {
    private static final Map<Integer, String> MAPPING =
            Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five", 6, "six", 7, "seven", 8, "eight", 9, "nine");
    private static final String DELIMITER = " ";

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
               .collect(Collectors.groupingBy(s -> MAPPING.get(Integer.parseInt(s)), LinkedHashMap::new,
                                              Collectors.toList()))
               .forEach((s, list) -> doDescribe(joiner, s, list));
        return joiner.toString();
    }

    private static void doDescribe(StringJoiner joiner, String key, List<String> values) {
        int limit = MAPPING.size();
        int number = values.size();
        if (values.size() > MAPPING.size()) {
            joiner.add(MAPPING.get(limit)).add(key);
            number -= limit;
        }
        joiner.add(MAPPING.get(number)).add(key);
    }
}
