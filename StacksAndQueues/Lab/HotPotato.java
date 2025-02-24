package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] kids = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> names = new ArrayDeque<>();

        for (String current : kids) {
            names.offer(current);
        }
        while (names.size() > 1) {
            for (int i = 1; i < n; i++) {
                String first = names.poll();
                names.offer(first);
            }
            String removed = names.poll();
            System.out.println("Removed " + removed);
        }
        for (String name : names) {
            System.out.println("Last is " + name);
        }
    }
}
