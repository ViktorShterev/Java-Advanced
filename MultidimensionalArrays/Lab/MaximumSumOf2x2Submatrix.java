package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
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
        int[][] maxMatrix = new int[2][2];

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int current = matrix[i][j];
                int next = matrix[i][j + 1];
                int first = current + next;

                int current2 = matrix[i + 1][j];
                int next2 = matrix[i + 1][j + 1];
                int second = current2 + next2;

                int result = first + second;

                if (result > sum) {
                    sum = result;
                    maxMatrix = new int[][] {
                            {current, next},
                            {current2, next2}
                    };
                }
            }
        }
        for (int[] arr : maxMatrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
