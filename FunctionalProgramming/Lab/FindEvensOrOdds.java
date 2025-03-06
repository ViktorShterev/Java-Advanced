package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String condition = scanner.nextLine();

        Predicate<Integer> filter = condition.equals("even")
                ? n -> n % 2 == 0
                : n -> n % 2 != 0;

        printInt(numbers[0], numbers[1], filter);
    }
    public static void printInt (int start, int end, Predicate<Integer> sort) {
        System.out.println(IntStream.rangeClosed(start, end)
                .boxed()
                .filter(sort)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
