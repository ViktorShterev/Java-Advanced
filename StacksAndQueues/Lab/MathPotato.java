package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> names = new ArrayDeque<>();

        for (String current : kids) {
            names.offer(current);
        }
        int cycle = 1;
        while (names.size() > 1) {
            for (int i = 1; i < n; i++) {
                String first = names.poll();
                names.offer(first);
            }
            if (cycle % 2 == 0) {
                String prime = names.peek();
                System.out.println("Prime " + prime);
            } else {
                String removed = names.poll();
                System.out.println("Removed " + removed);
                cycle++;
            }
        }
        for (String name : names) {
            System.out.println("Last is " + name);
        }
    }
}
