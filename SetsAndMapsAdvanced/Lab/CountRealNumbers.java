package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (double current : input) {
            if (!numbers.containsKey(current)) {
                numbers.put(current, 1);
            } else {
                numbers.put(current, numbers.get(current) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.println(String.format("%.1f -> %d", entry.getKey(), entry.getValue()));
        }
    }
}
