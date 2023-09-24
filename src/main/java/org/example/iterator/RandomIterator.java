package org.example.iterator;


import java.util.Iterator;
import java.util.Random;

public class RandomIterator implements Iterable<Integer>{

    private final int count;
    private final int from;
    private final int to;

    private static final Random rnd;

    static {
        rnd = new Random();
    }

    public RandomIterator(Integer count, int from, int to) {
        this.count = count;
        this.from = from;
        this.to = to;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < count;
            }

            @Override
            public Integer next() {
                int number = rnd.nextInt(from, to + 1);
                counter++;
                return number;
            }
        };
    }
}