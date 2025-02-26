package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int row1 = 0;
        int col1 = 0;

        while (row1 < size && col1 < size) {
            int current = matrix[row1][col1];
            System.out.print(current + " ");
            row1++;
            col1++;
        }
        System.out.println();

        int row2 = size - 1;
        int col2 = 0;
        while (row2 >= 0 && col2 < size) {
            int current = matrix[row2][col2];
            System.out.print(current + " ");
            row2--;
            col2++;
        }
    }
}
