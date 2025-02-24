package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= numCommands; i++) {
            String commands = scanner.nextLine();

            if (commands.startsWith("1")) {
                int n = Integer.parseInt(commands.split(" ")[1]);
                stack.push(n);
            } else if (commands.startsWith("2")) {
                stack.pop();
            } else {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
