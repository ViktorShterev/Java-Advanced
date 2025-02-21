package WorkshopDataStructures.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element){
        Node newNode = new Node(element);

        if (!isEmpty()) {
            newNode.next = this.head;
            this.head.prev = newNode;

        } else {
            this.tail = newNode;
        }

        this.head = newNode;
        this.size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;

        this.size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty list.");
        }
        this.head = this.head.next;

        if (this.size > 1) {
            this.head.prev = null;
        }
        int result = this.head.value;
        this.size--;

        if (isEmpty()) {
            this.head = this.tail = null;
        }
        return result;
    }

    public int removeLast() {
        if (this.size < 2) {
            return removeFirst();
        }
        int result = this.tail.value;
        this.tail = this.tail.prev;
        this.tail.next = null;

        this.size--;
        return result;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int get(int index) {
        checkIndex(index);

        int result = 0;

        if (index <= this.size / 2) {
            Node currentNode = this.head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            result = currentNode.value;

        } else {
           Node currentNode = this.tail;

            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
            result = currentNode.value;
        }
        return result;
    }

    private void checkIndex(int index) {
        if (index < 0 && index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }

    private int[] toArray() {
        List<Integer> result = new ArrayList<>();
        forEach(result::add);
        return result.stream().mapToInt(e -> e).toArray();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }
}
