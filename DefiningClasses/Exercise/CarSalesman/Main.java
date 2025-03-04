package DefiningClasses.Exercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nEngines = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < nEngines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String engineModel = tokens[0];
            int enginePower = Integer.parseInt(tokens[1]);
            Engine engine = null;
            if (tokens.length == 2) {
                engine = new Engine(engineModel, enginePower);
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(engineModel, enginePower, displacement, efficiency);
            } else if (tokens.length == 3) {
                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(engineModel, enginePower, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = tokens[2];
                    engine = new Engine(engineModel, enginePower, efficiency);
                }
            }
            engines.put(engineModel, engine);
        }
        int nCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < nCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String carModel = tokens[0];
            String engine = tokens[1];
            Engine carEngine = engines.get(engine);
            Car car = null;
            if (tokens.length == 2) {
                car = new Car(carModel, carEngine);
            }
            if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(carModel, carEngine, weight, color);
            } else if (tokens.length > 2) {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(carModel, carEngine, weight);
                } catch (NumberFormatException e) {
                    String color = tokens[2];
                    car = new Car(carModel, carEngine, color);
                }
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
