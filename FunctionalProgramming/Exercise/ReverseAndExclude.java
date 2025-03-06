package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> isDivided = number -> number % n != 0;

        Consumer<List<Integer>> print = list -> list.forEach(el -> System.out.print(el + " "));

        Function<List<Integer>, List<Integer>> function = list ->
                list.stream()
                        .filter(isDivided)
                        .collect(Collectors.toList());

        numbers = function.apply(numbers);

        print.accept(numbers);
    }
}
