package DefiningClasses.Lab;

import java.util.Scanner;

public class CarInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = new Car("Lada", "Niva", 100);

        car.setHorsePower(80);

        String s = car.toString();

        System.out.println(s);
    }
}
