package IteratorsAndComparators.Exercise.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> setName = new TreeSet<>(new NameComparator());
        TreeSet<Person> setAge = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            setName.add(person);
            setAge.add(person);
        }
        for (Person person : setName) {
            System.out.println(person);
        }
        for (Person person : setAge) {
            System.out.println(person);
        }
    }
}
