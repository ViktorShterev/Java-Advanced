package ExamPrep1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondStack::push);

        int value = 0;
        while (!firstQueue.isEmpty() && !secondStack.isEmpty()) {
            int firstItem = firstQueue.peek();
            int lastItem = secondStack.peek();

            int sum = firstItem + lastItem;

            if (sum % 2 == 0) {
                value += sum;
                firstQueue.poll();
                secondStack.pop();
            } else {
                secondStack.pop();
                firstQueue.offer(lastItem);
            }
        }
        String boxOutput = firstQueue.isEmpty() ? "First magic box is empty."
                : "Second magic box is empty.";

        String valueOutput = value >= 90 ? "Wow, your prey was epic! Value: "
                : "Poor prey... Value: ";

        System.out.println(boxOutput);
        System.out.println(valueOutput + value);
    }
}
