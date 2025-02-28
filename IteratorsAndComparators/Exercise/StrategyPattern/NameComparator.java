package IteratorsAndComparators.Exercise.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person one, Person two) {
        int compared = Integer.compare(one.getName().length(), two.getName().length());

        if (compared == 0) {
            compared = Character.compare(one.getName().toLowerCase().charAt(0),
                    two.getName().toLowerCase().charAt(0));
        }
        return compared;
    }
}
