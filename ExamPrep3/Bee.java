package ExamPrep3;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        readMatrix(matrix, scanner);

        int startRow = -1;
        int startCol = -1;

        int flowers = 0;
        int polinatedFlowers = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("B")) {
                    startRow = row;
                    startCol = col;
                } else if (matrix[row][col].equals("f")) {
                    flowers++;
                }
            }
        }
        boolean isOut = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            int oldRow = startRow;
            int oldCol = startCol;

            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        startRow++;
                        isOut = true;
                    }
                    break;
                case "down":
                    startRow++;
                    if (startRow >= matrix.length) {
                        startRow--;
                        isOut = true;
                    }
                    break;
                case "left":
                    startCol--;
                    if (startCol < 0) {
                        startCol++;
                        isOut = true;
                    }
                    break;
                case "right":
                    startCol++;
                    if (startCol >= matrix.length) {
                        startCol--;
                        isOut = true;
                    }
                    break;
            }
            if (matrix[startRow][startCol].equals("f")) {
                flowers--;
                matrix[startRow][startCol] = "B";
                matrix[oldRow][oldCol] = ".";
                polinatedFlowers++;

            } else if (matrix[startRow][startCol].equals(".")) {
                matrix[startRow][startCol] = "B";
                matrix[oldRow][oldCol] = ".";

            } else if (matrix[startRow][startCol].equals("O")) {
                matrix[oldRow][oldCol] = ".";
                matrix[startRow][startCol] = ".";
                if (command.equals("up")) {
                    startRow--;
                } else if (command.equals("down")) {
                    startRow++;
                } else if (command.equals("left")) {
                    startCol--;
                } else if (command.equals("right")) {
                    startCol++;
                }
                if (matrix[startRow][startCol].equals("f")) {
                    flowers--;
                    matrix[startRow][startCol] = "B";
                    polinatedFlowers++;
                } else {
                    matrix[startRow][startCol] = "B";
                }
            } else if (isOut) {
                matrix[startRow][startCol] = ".";
                System.out.println("The bee got lost!");
                break;
            }
            command = scanner.nextLine();
        }
        if (polinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 - polinatedFlowers));
        } else {
            System.out.printf( "Great job, the bee manage to pollinate %d flowers!%n", polinatedFlowers);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void readMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}


