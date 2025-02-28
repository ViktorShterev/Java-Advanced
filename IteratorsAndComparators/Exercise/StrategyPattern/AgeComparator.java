package IteratorsAndComparators.Exercise.StrategyPattern;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person one, Person two) {
        return Integer.compare(one.getAge(), two.getAge());
    }
}
