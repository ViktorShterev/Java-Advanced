package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];
        char startLetter = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = "" + startLetter + (char) (startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char) (startLetter + 1);
        }
        printMatrix(rows, cols, matrix);
    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
