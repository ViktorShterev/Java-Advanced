package FunctionalProgramming.Exercise;

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> addNum = array -> Arrays.stream(array).map(number -> number += 1).toArray();

        Function<int[], int[]> subNum = array -> Arrays.stream(array).map(number -> number -= 1).toArray();

        Function<int[], int[]> mulNum = array -> Arrays.stream(array).map(number -> number *= 2).toArray();

        Consumer<int[]> printNum = array -> Arrays.stream(array).forEach(number -> System.out.print(number + " "));

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = addNum.apply(numbers);
                    break;
                case "subtract":
                    numbers = subNum.apply(numbers);
                    break;
                case "multiply":
                    numbers = mulNum.apply(numbers);
                    break;
                case "print":
                    printNum.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
