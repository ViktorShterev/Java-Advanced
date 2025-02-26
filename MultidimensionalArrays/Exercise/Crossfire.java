package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        List<List<Integer>> matrix = new ArrayList<>();

        int start = 1;
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(start++);
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int row = Integer.parseInt(input.split("\\s+")[0]);
            int col = Integer.parseInt(input.split("\\s+")[1]);
            int radius = Integer.parseInt(input.split("\\s+")[2]);

            for (int rowToRemove = row - radius; rowToRemove <= row + radius; rowToRemove++) {
                if (rowToRemove < matrix.size() && rowToRemove >= 0
                    && col < matrix.get(rowToRemove).size() && col >= 0) {

                    matrix.get(rowToRemove).remove(col);
                }
            }
            for (int colToRemove = col + radius; colToRemove >= col - radius; colToRemove--) {
                if (row < matrix.size() && row >= 0
                        && colToRemove < matrix.get(row).size() && colToRemove >= 0) {

                    matrix.get(row).remove(colToRemove);
                }
            }
            matrix.removeIf(List::isEmpty);

            input = scanner.nextLine();
        }
        for (List<Integer> row : matrix) {
            for (int i : row) {
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
