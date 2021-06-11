package ru.netology;

import java.util.*;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    List<Integer> randomsList = new ArrayList<>();

    public Randoms(int min, int max) {
        random = new Random();
        int it = 0;
        int diff = max - min;
        try {
            while (true) {
                int i = random.nextInt(diff + 1);
                i += min;
                randomsList.add(i);
            }
        } catch (OutOfMemoryError ie) {
            System.out.println("Создано " + (randomsList.size() + 1) + " случайных чисел. Память переполнена!");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int next = 0;

            @Override
            public boolean hasNext() {
                return next < randomsList.size();
            }

            @Override
            public Integer next() {
                if (next < randomsList.size()) {
                    int num = randomsList.get(next);
                    next++;
                    return num;
                }
                throw new NoSuchElementException();
            }
        };
    }
}
