package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            Double grade = Double.parseDouble(input[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }
        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {

            double sum = 0;
            List<Double> values = entry.getValue();
            for (Double value : values) {
                sum += value;
            }
            double average = sum / values.size();

            System.out.printf("%s -> ", entry.getKey());
            values.forEach(value -> System.out.printf("%.2f ", value));
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
