package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split("\\s+")[0]);
        int m = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> thirdSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int first = Integer.parseInt(scanner.nextLine());
            firstSet.add(first);
        }
        for (int i = 0; i < m; i++) {
            int second = Integer.parseInt(scanner.nextLine());
            secondSet.add(second);
        }
        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                thirdSet.add(integer);
            }
        }
        for (Integer integer : thirdSet) {
            System.out.print(integer + " ");
        }
    }
}
