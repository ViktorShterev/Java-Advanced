package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String direction = input.split(", ")[0];
            String car = input.split(", ")[1];

            if (direction.equals("IN")) {
                cars.add(car);
            } else {
                cars.remove(car);
            }
            input = scanner.nextLine();
        }
        String output = cars.isEmpty()
                ? "Parking Lot is Empty"
                : cars.stream().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(output);
    }
}
