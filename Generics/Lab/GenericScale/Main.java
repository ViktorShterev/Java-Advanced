package Generics.Lab.GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scaleInt = new Scale<>(8, 6);
        Scale<String> stringScale = new Scale<>("A", "Z");

        System.out.println(scaleInt.getHeavier());
        System.out.println(stringScale.getHeavier());

        System.out.println(new Scale<Double>(2.5, 2.5).getHeavier());
    }
}
