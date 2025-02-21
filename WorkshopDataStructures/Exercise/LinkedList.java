package WorkshopDataStructures.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LinkedList {

    private Node head;
    private int size;

    public void addFirst(int element){
        Node newNode = new Node(element);

        if (!isEmpty()) {
            newNode.next = this.head;
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
        Node currentNode = this.head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        this.size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty list.");
        }
        this.head = this.head.next;
        int result = this.head.value;
        this.size--;

        return result;
    }

    public int removeLast() {
        if (this.size < 2) {
           return removeFirst();
        }
        int result = 0;
        Node currentNode = this.head;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        result = currentNode.next.value;
        currentNode.next = null;
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
        int currentNodeIndex = 0;
        Node currentNode = this.head;

        while (currentNode.next != null) {
            if (currentNodeIndex == index) {
                result = currentNode.value;
                break;
            }
            currentNodeIndex++;
            currentNode = currentNode.next;
        }
        return result;
    }

    private void checkIndex(int index) {
        if (index < 0 && index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }

    private int[] toArray() {
        int[] array = new int[this.size];
        int counter = 0;
        Node currentNode = this.head;

        while (currentNode.next != null) {
            array[counter] = currentNode.value;
            counter++;
            currentNode = currentNode.next;
        }
        return array;

//        List<Integer> result = new ArrayList<>();
//        forEach(result::add);
//        return result.stream().mapToInt(e -> e).toArray();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }
}
