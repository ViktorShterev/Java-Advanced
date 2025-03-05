package ExercisesWithClasses.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }
    public boolean remove(String manufacturer, String model){
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar() {
       return this.data.stream().max(Comparator.comparing(Car::getYear)).get();
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics() {
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append("The cars are parked in " + this.type + ":" + System.lineSeparator());
         this.data.forEach(c -> stringBuilder.append(c.toString()).append(System.lineSeparator()));

         return stringBuilder.toString();
    }
}
