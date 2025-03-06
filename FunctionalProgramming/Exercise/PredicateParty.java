package FunctionalProgramming.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String text = scanner.nextLine();
        while (!text.equals("Party!")) {
            Predicate<String> predicate = null;

            String command = text.split("\\s+")[0];
            String option = text.split("\\s+")[1];
            String token = text.split("\\s+")[2];

            if (option.equals("Length")) {
                predicate = word -> word.length() == Integer.parseInt(token);
            } else if (option.equals("StartsWith")) {
                predicate = word -> word.startsWith(token);
            } else {
                predicate = word -> word.endsWith(token);
            }

            if (command.equals("Remove")) {
                ArrayList<String> toRemove = new ArrayList<>();
                for (String guest : input) {
                    if (predicate.test(guest)) {
                        toRemove.add(guest);
                    }
                }
                input.removeAll(toRemove);
            } else {
                ArrayList<String> toAdd = new ArrayList<>();
                for (String guest : input) {
                    if (predicate.test(guest)) {
                        toAdd.add(guest);
                    }
                }
                input.addAll(toAdd);
            }
            text = scanner.nextLine();
        }
        if (input.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(input.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}
