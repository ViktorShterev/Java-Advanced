package StacksAndQueues.Exercise;

import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stackText = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder current = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            if (input.startsWith("1")) {
                String text = input.split("\\s+")[1];
                current.append(text);
                stackText.push(current.toString());

            } else if (input.startsWith("2")) {
                int count = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
                int startIndex = current.length() - count;
                current.delete(startIndex, startIndex + count);
                stackText.push(current.toString());

            } else if (input.startsWith("3")) {
                int index = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
                char symbol = current.charAt(index - 1);
                System.out.println(symbol);

            } else if (input.startsWith("4")) {
                if (stackText.size() > 1) {
                stackText.pop();
                current = new StringBuilder(stackText.peek());
                } else {
                    current = new StringBuilder();
                }
            }
        }
    }
}
