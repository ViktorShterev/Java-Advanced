package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        readMatrix(scanner, size, matrix);

        int first = 0;
        int row1 = 0;
        int col1 = 0;
        first = firstDiagonal(size, matrix, first, row1, col1);

        int second = 0;
        int row2 = size - 1;
        int col2 = 0;
        second = secondDiagonal(size, matrix, second, row2, col2);

        System.out.println(Math.abs(first - second));
    }

    private static int secondDiagonal(int size, int[][] matrix, int second, int row2, int col2) {
        while (row2 >= 0 && col2 < size) {
            int current = matrix[row2][col2];
            second += current;
            row2--;
            col2++;
        }
        return second;
    }

    private static int firstDiagonal(int size, int[][] matrix, int first, int row1, int col1) {
        while (row1 < size && col1 < size) {
            int current = matrix[row1][col1];
            first += current;
            row1++;
            col1++;
        }
        return first;
    }


    private static void readMatrix(Scanner scanner, int size, int[][] matrix) {
        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine()
                    .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
