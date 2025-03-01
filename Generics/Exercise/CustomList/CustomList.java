package Generics.Exercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public T remove(int element) {
       return this.values.remove(element);
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int first, int second) {
        Collections.swap(this.values, first, second);
    }

    public int countGreaterThan(T element) {
       return (int) this.values.stream().filter(value -> value.compareTo(element) > 0).count();
    }

    public T getMax() {
       return Collections.max(this.values);
    }

    public T getMin() {
        return Collections.min(this.values);
    }

    public int size() {
        return this.values.size();
    }

    public T get(int index) {
        return this.values.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(value);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
