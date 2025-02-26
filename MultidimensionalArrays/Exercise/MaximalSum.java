package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine()
                    .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] maxMatrix = new int[3][3];
        int sum = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int first = matrix[row][col];
                int second = matrix[row][col + 1];
                int third = matrix[row][col + 2];
                int result = first + second + third;

                int first1 = matrix[row + 1][col];
                int second1 = matrix[row + 1][col + 1];
                int third1 = matrix[row + 1][col + 2];
                int result1 = first1 + second1 + third1;

                int first2 = matrix[row + 2][col];
                int second2 = matrix[row + 2][col + 1];
                int third2 = matrix[row + 2][col + 2];
                int result2 = first2 + second2 + third2;

                int end = result + result2 + result1;

                if (end > sum) {
                    sum = end;
                    maxMatrix = new int[][] {
                            {first, second, third},
                            {first1, second1, third1},
                            {first2, second2, third2}
                    };
                }
            }
        }
        System.out.println("Sum = " + sum);
        for (int i = 0; i < maxMatrix.length; i++) {
            for (int j = 0; j < maxMatrix[i].length; j++) {
                System.out.print(maxMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

