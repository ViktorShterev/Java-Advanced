package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> sitesStack = new ArrayDeque<>();
        ArrayDeque<String> sitesQueue = new ArrayDeque<>();

        String current = "";

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (sitesStack.size() > 1) {
                    sitesStack.pop();
                    System.out.println(sitesStack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (sitesQueue.size() > 1) {
                    sitesQueue.poll();
                    System.out.println(sitesQueue.peek());
                    sitesStack.push(current);
                } else {
                    System.out.println("no next URLs");
                }
            }
            else {
                current = input;
                sitesStack.push(current);
                sitesQueue.offer(current);
                System.out.println(sitesStack.peek());
            }
            input = scanner.nextLine();
        }
    }
}
