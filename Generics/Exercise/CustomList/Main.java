package Generics.Exercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String type = command.split(" ")[0];

            switch (type) {
                case "Add":
                    String itemAdd = command.split(" ")[1];
                    customList.add(itemAdd);
                    break;
                case "Remove":
                    int indexRemove = Integer.parseInt(command.split(" ")[1]);
                    customList.remove(indexRemove);
                    break;
                case "Contains":
                    String itemContains = command.split(" ")[1];
                    System.out.println(customList.contains(itemContains));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command.split(" ")[1]);
                    int secondIndex = Integer.parseInt(command.split(" ")[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String compared = command.split(" ")[1];
                    System.out.println(customList.countGreaterThan(compared));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
