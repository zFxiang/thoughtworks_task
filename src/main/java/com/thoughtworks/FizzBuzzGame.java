package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;


public class FizzBuzzGame {
    public static final String BUZZ = "Buzz";
    public static final String FIZZ = "Fizz";
    public static final String WHIZZ = "Whizz";
    private List<String> results = new ArrayList<>();

    public void start(int count) {
        for (int i = 1; i <= count; i++) {
            results.add(countOff(i));
        }
    }
    public String countOff(int num){
        if (isContainsThree(num)) {
            return FIZZ;
        }
        StringBuilder sb = new StringBuilder();
        if(num % 3 == 0){
            sb.append(FIZZ);
        }
        if(num % 5 == 0){
            sb.append(BUZZ);
        }
        if(num % 7 == 0){
            sb.append(WHIZZ);
        }
        return sb.length() > 0 ? sb.toString() : String.valueOf(num);
    }

    private boolean isContainsThree(int num) {
        int temp = num;
        while (temp != 0){
            if(temp % 10 == 3){
                return true;
            }
            temp /= 10;
        }
        return false;
    }

    public List<String> getResults() {
        return results;
    }
}


