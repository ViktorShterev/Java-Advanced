package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine()
                    .split(", ")).mapToInt(Integer::parseInt)
                    .toArray();
        }
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = matrix[i][j];
                sum += current;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
