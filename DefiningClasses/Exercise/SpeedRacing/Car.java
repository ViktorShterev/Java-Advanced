package DefiningClasses.Exercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distance;

    public Car(String model, double fuelAmount, double fuelCost, double distance) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = distance;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setDistance(double distance) {
        this.distance += distance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distance);
    }
}
