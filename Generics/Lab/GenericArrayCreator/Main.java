package Generics.Lab.GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] integers = ArrayCreator.<Integer>create(10, 13);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        String[] strings = ArrayCreator.<String>create(String.class, 3, "Java");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
