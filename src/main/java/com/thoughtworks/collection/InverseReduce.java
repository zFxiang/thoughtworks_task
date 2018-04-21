package com.thoughtworks.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new LinkedList<>();
        while (true){
            int i = random.nextInt(3);
            number -= i;
            if(number <= 0){
                break;
            }
            result.add(number);
        }
        return result;
    }
}
