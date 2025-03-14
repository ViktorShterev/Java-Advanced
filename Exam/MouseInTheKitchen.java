package Exam;

import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(",");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        String[][] matrix = new String[row][col];

        readMatrix(matrix, scanner);

        int mouseRow = -1;
        int mouseCol = -1;

        int cheese = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("M")) {
                    mouseRow = r;
                    mouseCol = c;
                }
                if (matrix[r][c].equals("C")) {
                    cheese++;
                }
            }
        }
        boolean isOut = false;
        boolean isTrapped = false;
        String command = scanner.nextLine();
        while (!command.equals("danger")) {
            int startRow = mouseRow;
            int startCol = mouseCol;

            switch (command) {
                case "up":
                    mouseRow--;
                    if (mouseRow < 0) {
                        mouseRow++;
                        isOut = true;
                    }
                    break;
                case "down":
                    mouseRow++;
                    if (mouseRow >= matrix.length) {
                        mouseRow--;
                        isOut = true;
                    }
                    break;
                case "left":
                    mouseCol--;
                    if (mouseCol < 0) {
                        mouseCol++;
                        isOut = true;
                    }
                    break;
                case "right":
                    mouseCol++;
                    if (mouseCol >= matrix.length) {
                        mouseCol--;
                        isOut = true;
                    }
                    break;
            }
            if (isOut) {
                System.out.println("No more cheese for tonight!");
                break;

            } else if (matrix[mouseRow][mouseCol].equals("C")) {
                cheese--;
                matrix[startRow][startCol] = "*";
                matrix[mouseRow][mouseCol] = "M";
                if (cheese == 0) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }
            } else if (matrix[mouseRow][mouseCol].equals("T")) {
                matrix[startRow][startCol] = "*";
                matrix[mouseRow][mouseCol] = "M";
                System.out.println("Mouse is trapped!");
                isTrapped = true;
                break;

            } else if (matrix[mouseRow][mouseCol].equals("@")) {
                mouseRow = startRow;
                mouseCol = startCol;
            } else {
                matrix[startRow][startCol] = "*";
                matrix[mouseRow][mouseCol] = "M";
            }
            command = scanner.nextLine();
        }
        if (cheese > 0 && !isTrapped && !isOut) {
            System.out.println("Mouse will come back later!");
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
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
