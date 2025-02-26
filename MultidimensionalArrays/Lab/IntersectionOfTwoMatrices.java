package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, scanner);
        char[][] secondMatrix = readMatrix(rows, cols, scanner);

        char[][] thirdMatrix = new char[rows][cols];
        for (int i = 0; i < thirdMatrix.length; i++) {
            for (int j = 0; j < thirdMatrix[i].length; j++) {
                char first = firstMatrix[i][j];
                char second = secondMatrix[i][j];

                if (first == second) {
                    thirdMatrix[i][j] = first;
                } else {
                    thirdMatrix[i][j] = '*';
                }
                System.out.print(thirdMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < line.length; col++) {
                char current = line[col].charAt(0);
                matrix[row][col] = current;
            }
        }
        return matrix;
    }
}
