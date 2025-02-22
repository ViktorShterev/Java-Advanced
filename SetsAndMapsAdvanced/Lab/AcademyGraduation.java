package SetsAndMapsAdvanced.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine()
                     .split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            students.put(name, new ArrayList<>());

            for (double current : grades) {
                students.get(name).add(current);
            }
        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double sum = 0;
            for (double grade : entry.getValue()) {
                sum += grade;
            }
            double average = sum / entry.getValue().size();
            DecimalFormat zeros = new DecimalFormat("#.############################");

            System.out.printf("%s is graduated with %s%n", entry.getKey(), zeros.format(average));
        }
    }
}
