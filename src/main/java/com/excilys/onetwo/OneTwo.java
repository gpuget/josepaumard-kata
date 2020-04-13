package com.excilys.onetwo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

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

        var split = input.split(DELIMITER);
        return new StringJoiner(" ").add(MAPPING.get(split.length))
                                    .add(MAPPING.get(Integer.parseInt(split[0])))
                                    .toString();
    }
}
