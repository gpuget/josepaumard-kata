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

        StringJoiner joiner = new StringJoiner(DELIMITER);
        int count = 0;
        String last = "";
        for (String s : input.split(DELIMITER)) {
            count += 1;
            if (last.equals(s)) {
                last = s;
            } else {
                joiner.add(MAPPING.get(count)).add(MAPPING.get(Integer.parseInt(s)));
                count = 0;
            }
        }

        return joiner.toString();
    }
}
