package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, Integer> count = str -> str.split(", ").length;

        System.out.println("Count = " + count.apply(input));

        Function<String, Integer> sum = str -> Arrays.stream(str.split(", "))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("Sum = " + sum.apply(input));
    }
}
