package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> sites = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (sites.size() > 1) {
                    sites.pop();
                    System.out.println(sites.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                sites.push(input);
                System.out.println(sites.peek());
            }
            input = scanner.nextLine();
        }
    }
}
