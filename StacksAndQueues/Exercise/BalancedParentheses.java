package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        String input = scanner.nextLine();

        boolean isBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                openBrackets.push(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (openBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpen = openBrackets.pop();

                if (lastOpen == '(' && current == ')') {
                    isBalanced = true;
                } else if (lastOpen == '[' && current == ']'){
                    isBalanced = true;
                } else if (lastOpen == '{' && current == '}') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
