package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> numbers = e -> {

            int min = Integer.MAX_VALUE;
            for (Integer integer : e) {
                if (integer < min) {
                    min = integer;
                }
            }
            return min;
        };
        System.out.println(numbers.apply(input));
    }
}
