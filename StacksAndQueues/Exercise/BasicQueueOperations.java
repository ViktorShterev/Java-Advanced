package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int offer = scanner.nextInt();
        int poll = scanner.nextInt();
        int find = scanner.nextInt();

        for (int i = 1; i <= offer; i++) {
            int n = scanner.nextInt();
            queue.offer(n);
        }
        for (int i = 1; i <= poll; i++) {
            queue.poll();
        }
        if (queue.contains(find)) {
            System.out.println("true");
        } else {
            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue));
            } else {
                System.out.println(0);
            }
        }
    }
}
