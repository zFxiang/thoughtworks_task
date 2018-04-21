package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt((i) -> i).max().orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream().mapToInt((i) -> i).min().orElse(0);
    }

    public double getAverage() {
        return arrayList.stream().mapToDouble((i) -> i).average().orElse(Double.NaN);
    }

    public double getOrderedMedian() {
        List<Integer> list = new ArrayList<>(arrayList);
        Collections.sort(list);
        int size = list.size();
        if (Add.isEven(size)) {
            return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
        }
        return list.get(size / 2);
    }

    public int getFirstEven() {
        return arrayList.stream().reduce(-1, (i1, i2) -> {
            if (i1 == -1 && Add.isEven(i2)) {
                return i2;
            }
            return i1;
        });
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (Add.isEven(arrayList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        int size = singleLink.size();
        if (Add.isEven(size)) {
            return (singleLink.getNode(size / 2) + singleLink.getNode(size / 2 + 1)) / 2.0;
        }
        return (double) singleLink.getNode(size / 2);
    }

    public int getLastOdd() {
        int i = getIndexOfLastOdd();
        if (i == -1) {
            return 0;
        }
        return arrayList.get(i);
    }

    public int getIndexOfLastOdd() {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (Add.isOdd(arrayList.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
