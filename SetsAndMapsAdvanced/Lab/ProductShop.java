package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Double>> foodShops = new TreeMap<>();

        while (!input.equals("Revision")) {

            String[] inputParts = input.split(", ");
            String shop = inputParts[0];
            String product = inputParts[1];
            double price = Double.parseDouble(inputParts[2]);

            if (!foodShops.containsKey(shop)) {
                foodShops.put(shop, new LinkedHashMap<>());
                foodShops.get(shop).put(product, price);
            } else {
                foodShops.get(shop).put(product, price);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : foodShops.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            Map<String, Double> products = entry.getValue();
            for (Map.Entry<String, Double> doubleEntry : products.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", doubleEntry.getKey(), doubleEntry.getValue());
            }
        }
    }
}
