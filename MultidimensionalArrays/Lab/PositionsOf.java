package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int number = Integer.parseInt(scanner.nextLine());

        boolean isMissing = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = matrix[i][j];

                if (current == number) {
                    System.out.println(i + " " + j);
                    isMissing = false;
                }
            }
        }
        if (isMissing) {
            System.out.println("not found");
        }
    }
}
