package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> list = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                list.put(name, email);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> stringEntry : list.entrySet()) {
            System.out.printf("%s -> %s%n", stringEntry.getKey(), stringEntry.getValue());
        }

//        emailsData.entrySet().removeIf(entry ->
//                entry.getValue().endsWith("uk")
//                        || entry.getValue().endsWith("us")
//                        || entry.getValue().endsWith("com"));
//        //запис: име(key) -> имейл(value)
//        emailsData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
