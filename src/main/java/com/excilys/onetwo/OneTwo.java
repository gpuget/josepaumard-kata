package com.excilys.onetwo;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OneTwo {
    private static final Map<Integer, String> MAPPING;
    private static final String DELIMITER = " ";

    static {
        HashMap<Integer, String> tmp = new HashMap<>();
        String[] values = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < values.length; i++) {
            tmp.put(i + 1, values[i]);
        }
        MAPPING = Collections.unmodifiableMap(tmp);
    }

    private OneTwo() {
        throw new AssertionError("You shall not pass !");
    }

    public static String describe(String input) {
        if (input.isBlank()) {
            return input;
        }

        StringJoiner joiner = new StringJoiner(DELIMITER);
        Pattern.compile(DELIMITER)
               .splitAsStream(input)
               .collect(Collectors.groupingBy(s -> MAPPING.get(Integer.parseInt(s)), LinkedHashMap::new,
                                              Collectors.toList()))
               .forEach((s, list) -> joiner.add(MAPPING.get(list.size())).add(s));
        return joiner.toString();
    }
}
