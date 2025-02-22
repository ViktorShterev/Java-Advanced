package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!command.equals("search")) {
            String[] input = command.split("-");
            String name = input[0];
            String number = input[1];

            phonebook.putIfAbsent(name, number);
            phonebook.put(name, number);

            command = scanner.nextLine();
        }
        String text = scanner.nextLine();
        while (!text.equals("stop")) {

            if (phonebook.containsKey(text)) {
                System.out.printf("%s -> %s%n", text, phonebook.get(text));
            } else {
                System.out.printf("Contact %s does not exist.%n", text);
            }
            text = scanner.nextLine();
        }
    }
}
