package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0 && firstPlayer.size() > 0 && secondPlayer.size() > 0) {

            int firstDeck = firstPlayer.iterator().next();
            firstPlayer.remove(firstDeck);
            int secondDeck = secondPlayer.iterator().next();
            secondPlayer.remove(secondDeck);

            if (firstDeck > secondDeck) {
                firstPlayer.add(firstDeck);
                firstPlayer.add(secondDeck);
            } else if (secondDeck > firstDeck){
                secondPlayer.add(firstDeck);
                secondPlayer.add(secondDeck);
            }
        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
