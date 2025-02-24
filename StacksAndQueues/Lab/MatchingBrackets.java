package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                int begin = stack.pop();
                System.out.println(input.substring(begin, i + 1));
            }
        }
    }
}
