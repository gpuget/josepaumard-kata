package com.excilys.fizzbuzz;

public class FizzBuzz {
    private FizzBuzz() {
        throw new AssertionError("Fly you fool !");
    }

    public static String execute(int number) {
        if (number == 3) {
            return "Fizz";
        }

        return String.valueOf(number);
    }
}
