package com.excilys.fizzbuzz;

public class FizzBuzz {
    private FizzBuzz() {
        throw new AssertionError("Fly you fool !");
    }

    public static String execute(int number) {
        if (isDivisibleBy3(number)) {
            return "Fizz";
        }

        if (isDivisibleBy5(number)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private static boolean isDivisibleBy5(int number) {
        return (number % 5) == 0;
    }

    private static boolean isDivisibleBy3(int number) {
        return (number % 3) == 0;
    }
}
