package SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> counts = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (counts.containsKey(current)) {
                int value = counts.get(current);
                counts.put(current, value + 1);
            } else {
                counts.put(current, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
