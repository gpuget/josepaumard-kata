package com.excilys.onetwo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OneTwo {
    private static final Map<Integer, String> MAPPING;
    private static final String DELIMITER = " ";

    static {
        HashMap<Integer, String> tmp = new HashMap<>();
        String[] values = {"one", "two"};
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

        Map<String, List<String>> map = Pattern.compile(DELIMITER)
                                               .splitAsStream(input)
                                               .collect(Collectors.groupingBy(s -> MAPPING.get(Integer.parseInt(s))));

        StringJoiner joiner = new StringJoiner(DELIMITER);
        map.forEach((s, list) -> joiner.add(MAPPING.get(list.size())).add(s));
        return joiner.toString();
    }
}
