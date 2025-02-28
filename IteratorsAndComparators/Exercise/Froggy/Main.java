package IteratorsAndComparators.Exercise.Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        Lake lake = new Lake(Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        List<String> output = new ArrayList<>();

        for (Integer value : lake) {
            output.add(String.valueOf(value));
        }
        System.out.println(String.join(", ", output));
    }
}
