package StacksAndQueues.Lab;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Collections.reverse(input);

        for (String s : input) {
            stack.push(s);
        }
        ///Arrays.stream(scanner.nextLine().split("\\s+"))
              ///  .forEach(stack::push);

        int result = 0;
        while (stack.size() >= 2) {

            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());

            if (operator.equals("-")) {
                result = first - second;
            } else {
                result = first + second;
            }
            stack.push(String.valueOf(result));
        }
        System.out.println(result);
    }
}
