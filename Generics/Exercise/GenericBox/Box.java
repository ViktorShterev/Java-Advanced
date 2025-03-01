package Generics.Exercise.GenericBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box <T extends Comparable<T>> {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T first = this.values.get(firstIndex);
        T second = this.values.get(secondIndex);

        this.values.set(firstIndex, second);
        this.values.set(secondIndex, first);

       // Collections.swap(this.values, firstIndex, secondIndex);
    }

    public int countGreaterThen(T element) {
        int count = 0;

        for (T value : values) {
            if (value.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s", value.getClass().getName(), value.toString()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
