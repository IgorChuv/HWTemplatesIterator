package ru.netology;

import java.util.*;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    protected int min;
    protected int max;
    protected boolean endlessIterationBegin;

    public Randoms(int min, int max) {
        if(max < min){
            throw new IllegalArgumentException("Максимальное число не может быть меньше минимального! ");
        }
        this.min = min;
        this.max = max;
        random = new Random();
        endlessIterationBegin = true;

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return endlessIterationBegin;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return min + random.nextInt(max - min + 1);
                }
                throw new NoSuchElementException();
            }
        };
    }
}
