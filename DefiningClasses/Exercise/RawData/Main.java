package DefiningClasses.Exercise.RawData;

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
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            cars.put(model, new Car(model, new Engine(engineSpeed, enginePower),
                    new Cargo(cargoWeight, cargoType), new Tires(tire1Pressure, tire1Age,
                    tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age)));
        }
        String command = scanner.nextLine();

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            Car car = entry.getValue();

            String type = car.getCargo().getCargoType();
            double tire1Pressure = car.getTires().getTire1Pressure();
            double tire2Pressure = car.getTires().getTire2Pressure();
            double tire3Pressure = car.getTires().getTire3Pressure();
            double tire4Pressure = car.getTires().getTire4Pressure();

            if (command.equals("fragile")) {
            if (type.equals("fragile") && (tire1Pressure < 1 || tire2Pressure < 1
                    || tire3Pressure < 1 || tire4Pressure < 1)) {
                System.out.println(car.getModel());
            }
            } else if (command.equals("flamable")) {
                if (type.equals("flamable") && car.getEngine().getEnginePower() > 250) {
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
