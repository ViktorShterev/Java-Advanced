package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tools = scanner.nextLine();
        String substances = scanner.nextLine();
        String challenges = scanner.nextLine();

        ArrayDeque<Integer> toolsQueue = Arrays.stream(tools.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(substances.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(substancesStack::push);

        List<Integer> challengesList = Arrays.stream(challenges.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()) {
            int currentTool = toolsQueue.peek();
            int currentSub = substancesStack.peek();
            int multiply = currentTool * currentSub;

            if (challengesList.contains(multiply)) {
                toolsQueue.poll();
                substancesStack.pop();
                challengesList.remove(Integer.valueOf(multiply));

            } else {
                toolsQueue.offer(toolsQueue.poll() + 1);
                if (currentSub - 1 == 0) {
                    substancesStack.pop();
                } else {
                    substancesStack.push(substancesStack.pop() - 1);
                }
            }
        }
        if (!challengesList.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }
        if (!toolsQueue.isEmpty()) {
            System.out.print("Tools: ");
            System.out.println(toolsQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (!substancesStack.isEmpty()) {
            System.out.print("Substances: ");
            System.out.println(substancesStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (!challengesList.isEmpty()) {
            System.out.print("Challenges: ");
            System.out.println(challengesList.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
