package IteratorsAndComparators.Exercise.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> lake;

    public Lake(List<Integer> lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    class Frog implements Iterator<Integer> {
        int index = 0;
        boolean areWeFinishedFirstRound = false;

        @Override
        public boolean hasNext() {
            return index < lake.size();
        }

        @Override
        public Integer next() {

            int currentIndex = index;
            index += 2;

            if (index >= lake.size() && !areWeFinishedFirstRound) {
                index = 1;
                areWeFinishedFirstRound = true;
            }
            return lake.get(currentIndex);
        }
    }
}
