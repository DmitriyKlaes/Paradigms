package org.example.iterator;

public class Main {
    public static void main(String[] args) {
        RandomIterator irr = new RandomIterator(5,0,3);
        for (Integer integer : irr) {
            System.out.println(integer);
        }

    }
}
