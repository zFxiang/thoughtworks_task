package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map((i) -> i * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream()
                .filter((i) -> i > 0)
                .map((i) -> letters[i - 1])
                .collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream()
                .filter((i) -> i > 0)
                .map((i) -> {
                    String s = "";
                    while (i > 0) {
                        i--;
                        s = letters[i % 26] + s;
                        i = i / 26;
                    }
                    return s;
                })
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted((o1,o2) -> o2 - o1).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
