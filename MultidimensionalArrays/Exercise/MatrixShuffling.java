package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] inputParts = input.split("\\s+");

            String command = inputParts[0];

            if (command.equals("swap") && inputParts.length == 5) {
                int row1 = Integer.parseInt(inputParts[1]);
                int col1 = Integer.parseInt(inputParts[2]);
                int row2 = Integer.parseInt(inputParts[3]);
                int col2 = Integer.parseInt(inputParts[4]);

                if (row1 < 0 || row1 >= rows && col1 < 0 || col1 >= cols
                        && row2 < 0 || row2 >= rows && col2 < 0 || col2 >= cols) {
                    System.out.println("Invalid input!");
                } else {
                    String first = matrix[row1][col1];
                    String second = matrix[row2][col2];
                    matrix[row1][col1] = second;
                    matrix[row2][col2] = first;

                    for (String[] stringsArr : matrix) {
                        for (String s : stringsArr) {
                            System.out.print(s + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }
}
