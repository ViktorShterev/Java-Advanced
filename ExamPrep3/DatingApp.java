package ExamPrep3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String males = scanner.nextLine();
        String females = scanner.nextLine();

        ArrayDeque<Integer> femalesQueue = Arrays.stream(females.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(males.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        int match = 0;

        while (!femalesQueue.isEmpty() && !malesStack.isEmpty()) {
            int currentMan = malesStack.peek();
            int currentWoman = femalesQueue.peek();

            if ((currentMan % 25 == 0 && currentMan != 0) || (currentWoman % 25 == 0 && currentWoman != 0)) {
                if (currentMan % 25 == 0) {
                    malesStack.pop();
                    malesStack.pop();
                } else {
                    femalesQueue.poll();
                    femalesQueue.poll();
                }
            } else if (currentMan <= 0 || currentWoman <= 0) {
                if (currentMan <= 0) {
                    malesStack.pop();
                } else {
                    femalesQueue.poll();
                }
            } else if (currentMan == currentWoman) {
                match++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }
        }
        System.out.println("Matches: " + match);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(malesStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(femalesQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
