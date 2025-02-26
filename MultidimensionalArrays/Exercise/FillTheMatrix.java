package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[rows][rows];
        if (pattern.equals("A")) {
            readMatrix(matrix);
        } else {
            readMatrixB(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrixA) {
        for (int[] arr : matrixA) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrixB(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
    }


    private static void readMatrix(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }
}
