package Generics.Lab.Jar;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> integerJar = new Jar<>();

        integerJar.add(4);
        integerJar.add(15);

        integerJar.remove();
    }
}
