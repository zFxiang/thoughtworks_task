package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {

    public static boolean isOdd(int i){
        return i % 2 == 1;
    }
    public static boolean isEven(int i){
        return !isOdd(i);
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            return getSumOfEvens(rightBorder,leftBorder);
        }
        return IntStream.range(leftBorder,rightBorder + 1).filter(Add::isEven).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            return getSumOfOdds(rightBorder,leftBorder);
        }
        return IntStream.range(leftBorder,rightBorder + 1).filter(Add::isOdd).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt((i) -> i * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map((i) -> {
            if(isOdd(i)){
                return i * 3 + 2;
            }
            return i;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(Add::isOdd).mapToInt((i) -> i * 3 + 5).sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : arrayList) {
            if(isEven(i)){
                list.add(i);
            }
        }
        Collections.sort(list);
        int size = list.size();
        if(isEven(size)){
            return (list.get(size/2) + list.get(size/2 -1)) / 2.0;
        }
        return list.get(size / 2);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(Add::isEven).mapToDouble((i) -> i).average().orElse(Double.NaN);
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        for (Integer i : arrayList) {
            if(isEven(i) && specialElment.equals(i)){
                return true;
            }
        }
        return false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(Add::isEven).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (Integer i : arrayList) {
            if(isEven(i)){
                evenList.add(i);
            }else {
                oddList.add(i);
            }
        }
        evenList.sort(Comparator.comparingInt(o -> o));
        oddList.sort((o1, o2) -> o2 - o1);
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            result.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return result;
    }
}
