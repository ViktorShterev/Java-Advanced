package Generics.Exercise.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            box.add(input);
        }
//        String[] indexes = scanner.nextLine().split(" ");
//        int firstIndex = Integer.parseInt(indexes[0]);
//        int secondIndex = Integer.parseInt(indexes[1]);
//
//        box.swap(firstIndex, secondIndex);

        double compared = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreaterThen(compared));

        //System.out.print(box);
    }
}
