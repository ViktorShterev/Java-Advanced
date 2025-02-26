package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] matrix = readMatrix(scanner, rows, cols);
        char replaceChar = scanner.nextLine().charAt(0);

        String[] startingPoint = scanner.nextLine().split(" ");
        int startRow = Integer.parseInt(startingPoint[0]);
        int startCol = Integer.parseInt(startingPoint[1]);
        char startChar = matrix[startRow][startCol];

        fillMatrixWithReplaceChar(startRow, startCol, replaceChar, startChar, matrix);

        print(matrix);
    }

    private static void fillMatrixWithReplaceChar(int startRow, int startCol, char replaceChar, char startChar, char[][] matrix) {
        if (matrix[startRow][startCol] != startChar) {
            return;
        }
        matrix[startRow][startCol] = replaceChar;

        if (startRow - 1 >= 0) {
            fillMatrixWithReplaceChar(startRow - 1, startCol, replaceChar, startChar, matrix);
        }
        if (startRow + 1 < matrix.length) {
            fillMatrixWithReplaceChar(startRow + 1, startCol, replaceChar, startChar, matrix);
        }
        if (startCol - 1 >= 0) {
            fillMatrixWithReplaceChar(startRow, startCol - 1, replaceChar, startChar, matrix);
        }
        if (startCol + 1 < matrix[startRow].length) {
            fillMatrixWithReplaceChar(startRow, startCol + 1, replaceChar, startChar, matrix);
        }
    }

    static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] elements = scanner.nextLine().split(" ");

            for (int col = 0; col < elements.length; col++) {
                char currentSymbol = elements[col].charAt(0);
                matrix[row][col] = currentSymbol;
            }
        }
        return matrix;
    }

    static void print(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
