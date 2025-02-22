package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> geo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            geo.putIfAbsent(continent, new LinkedHashMap<>());
            geo.get(continent).putIfAbsent(country, new ArrayList<>());
            geo.get(continent).get(country).add(city);
        }
        for (Map.Entry<String, Map<String, List<String>>> entry : geo.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());

            Map<String, List<String>> countries = entry.getValue();
            for (Map.Entry<String, List<String>> listEntry : countries.entrySet()) {
                System.out.printf("%s -> ", listEntry.getKey());

                List<String> cities = listEntry.getValue();
                System.out.print(String.join(", ", cities));
                System.out.println();
            }
        }
    }
}
