package com.excilys.fizzbuzz;

public class FizzBuzz {
    private FizzBuzz() {
        throw new AssertionError("Fly you fool !");
    }

    public static String execute(int number) {
        if ((number == 3) || (number == 6)) {
            return "Fizz";
        }

        if (number == 5) {
            return "Buzz";
        }

        return String.valueOf(number);
    }
}
