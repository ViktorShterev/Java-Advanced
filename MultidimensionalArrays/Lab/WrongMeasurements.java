package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine()
                    .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();
        }
        String[] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        int current = matrix[row][col];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == current) {
                    matrix[r][c] = getNearestSum(r, c, matrix, current);
                }
            }
        }
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int getNearestSum(int r, int c, int[][] matrix, int current) {
        int sum = 0;

        if (c + 1 < matrix[r].length) {
            if (matrix[r][c + 1] != current) {
                sum += matrix[r][c + 1];
            }
        }
        if (c - 1 >= 0) {
            if (matrix[r][c - 1] != current) {
                sum += matrix[r][c - 1];
            }
        }
        if (r + 1 < matrix.length) {
            if (matrix[r + 1][c] != current) {
                sum += matrix[r + 1][c];
            }
        }
        if (r - 1 >= 0) {
            if (matrix[r - 1][c] != current) {
                sum += matrix[r - 1][c];
            }
        }
        return sum;
    }
}
