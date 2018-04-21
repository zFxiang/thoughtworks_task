package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new LinkedList<>();
        for (Integer[] arr : array) {
            Collections.addAll(result, arr);
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        Set<Integer> set = new LinkedHashSet<>();
        for (Integer[] arr : array) {
            Collections.addAll(set, arr);
        }
        return new ArrayList<>(set);
    }
}
