package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] commands = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int numbers = commands[0];
        int pops = commands[1];
        int element = commands[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int [] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers; i++) {
            int n = elements[i];
            stack.push(n);
        }
        for (int i = 1; i <= pops; i++) {
            stack.pop();
        }
        int smallest = Integer.MAX_VALUE;
        boolean isFalse = true;
        for (Integer integer : stack) {
            if (integer == element) {
                System.out.println("true");
                isFalse = false;
                break;
            } else {
                if (integer < smallest) {
                    smallest = integer;
                }
            }
        }
        if (isFalse && stack.isEmpty()) {
            System.out.println(0);
        } else if (isFalse) {
            System.out.println(smallest);
        }

       /// if (stack.contains(element)) {
          //  System.out.println("true");
        //} else {
            //if (!stack.isEmpty()) {
           //     System.out.println(Collections.min(stack));
          //  } else {
             //   System.out.println(0);
           // }
         //}
    }
}
