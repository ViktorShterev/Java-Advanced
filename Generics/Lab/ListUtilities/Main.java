package Generics.Lab.ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = List.of(2, 6, 50, 13);
        List<String> strings = List.of("2", "6", "50", "13");

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(strings));

    }
}
