package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int step = left < right ? 1 : -1;
        List<Integer> result = new ArrayList<>((right - left) * step + 1);
        for (int i = left; (i - right) * step <= 0; i += step) {
            result.add(i);
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int step = left < right ? 2 : -2;
        if (Add.isOdd(left)){
            left += step / 2;
        }
        List<Integer> result = new LinkedList<>();
        for (int i = left; (i - right) * step <= 0; i += step) {
            result.add(i);
        }
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> result = new LinkedList<>();
        for (int i : array) {
            if(Add.isEven(i)){
                result.add(i);
            }
        }
        return result;
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new LinkedList<>();
        for (int i : firstArray) {
            set.add(i);
        }
        for (int i : secondArray) {
            if(set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(firstArray));
        set.addAll(Arrays.asList(secondArray));
        return new ArrayList<>(set);
    }
}
