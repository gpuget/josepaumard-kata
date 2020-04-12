package com.excilys.fizzbuzz;

public class FizzBuzz {
    private FizzBuzz() {
        throw new AssertionError("Fly you fool !");
    }

    public static String execute(int number) {
        StringBuilder builder = new StringBuilder();

        if (isDivisibleBy3(number)) {
            builder.append("Fizz");
        }

        if (isDivisibleBy5(number)) {
            builder.append("Buzz");
        }

        String res = builder.toString();
        return res.isEmpty()
               ? String.valueOf(number)
               : res;
    }

    private static boolean isDivisibleBy5(int number) {
        return isDivisibleBy(number, 5);
    }

    private static boolean isDivisibleBy3(int number) {
        return isDivisibleBy(number, 3);
    }

    private static boolean isDivisibleBy(int number, int by) {
        return (number % by) == 0;
    }
}
