package WorkshopDataStructures.Lab;

import java.util.function.Consumer;

public class SmartArray {

    private final static int INITIAL_CAPACITY = 8;

    private int[] elements;
    private int size;

    public SmartArray() {
        this.elements = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(int element) {

        if (this.size == this.elements.length) {
            this.elements = grow();
        }

        this.elements[this.size] = element;
        this.size++;
    }

    private int[] grow() {
        int[] newElements = new int[this.elements.length * 2];

        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);

        return newElements;
    }

    public int get(int index) {

        ensureIndex(index);
        return this.elements[index];
    }

    private void ensureIndex(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + this.size);
        }
    }

    public int size() {
        return this.size;
    }

    public int remove(int index) {
        ensureIndex(index);

        int removed = this.elements[index];

        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[this.size - 1] = 0;
        this.size--;

        if (this.size <= this.elements.length / 4) {
            this.elements = shrink();
        }

        return removed;
    }

    private int[] shrink() {
        int reduceFactor = 2;

        if (this.elements.length / reduceFactor >= INITIAL_CAPACITY) {

            int[] newElements = new int[this.elements.length / reduceFactor];

            if (this.size >= 0) System.arraycopy(this.elements, 0, newElements, 0, this.size);

            return newElements;
        }
        return this.elements;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (element == elements[i]) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        ensureIndex(index);

        int lastElement = this.size -1;

        for (int i = this.size - 1; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }

        this.elements[index] = element;
        add(lastElement);
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.elements[i]);
        }
    }
}
