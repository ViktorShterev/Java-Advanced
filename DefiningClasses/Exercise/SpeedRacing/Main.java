package DefiningClasses.Exercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            cars.put(model,new Car(model, fuelAmount, fuelCost, 0));
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            String[] tokens = command.split("\\s+");
            String modelD = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            double maxDistance = cars.get(modelD).getFuelAmount() / cars.get(modelD).getFuelCost();
            if (maxDistance >= distance) {
                cars.get(modelD).setDistance(distance);
                cars.get(modelD).setFuelAmount((maxDistance - distance) * cars.get(modelD).getFuelCost());
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
