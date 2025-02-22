package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!command.equals("JOKER")) {
            String[] tokens = command.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            players.putIfAbsent(name, new LinkedHashSet<>());

            for (int i = 0; i < cards.length; i++) {
                String current = cards[i];
                players.get(name).add(current);
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {
            int one = 0;
            int two = 0;
            int result = 0;

            for (String s : entry.getValue()) {
                char first = s.charAt(0);
                char second = s.charAt(1);

                if (Character.isDigit(first)) {
                    one = Integer.parseInt(String.valueOf(first));
                    if (one == 1) {
                        one = 10;
                    }
                } else {
                    if (first == 'J') {
                      one = 11;
                    } else if (first == 'Q') {
                        one = 12;
                    } else if (first == 'K') {
                        one = 13;
                    } else if (first == 'A') {
                        one = 14;
                    }
                }
                if (Character.isDigit(second)) {
                    second = s.charAt(2);
                }
                if (second == 'S') {
                    two = 4;
                } else if (second == 'H') {
                    two = 3;
                } else if (second == 'D') {
                    two = 2;
                } else if (second == 'C') {
                    two = 1;
                }

                result += (one * two);
            }
            System.out.printf("%s: %d%n", entry.getKey(), result);
        }
    }
}
