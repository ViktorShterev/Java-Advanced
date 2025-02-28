package IteratorsAndComparators.Exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] inputParts = input.split(" ");

            String name = inputParts[0];
            int age = Integer.parseInt(inputParts[1]);
            String town = inputParts[2];

            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());

        Person personToCompare = people.get(n - 1);
        people.remove(personToCompare);

        int samePeople = 1;
        int diffPeople = 0;

        for (Person person : people) {
            if (person.compareTo(personToCompare) == 0) {
                samePeople++;
            } else {
                diffPeople++;
            }
        }

        if (samePeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", samePeople, diffPeople, people.size() + 1);
        }
    }
}
