package com.tw.model;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String no;
    private String name;
    private Map<String,Double> score = new HashMap<>();
    private double scoreTotal = 0.0;
    private double scoreAvg = 0.0;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getScore() {
        return score;
    }

    public void setScore(Map<String, Double> score) {
        this.score = score;
    }

    public double getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(double scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public double getScoreAvg() {
        return scoreAvg;
    }

    public void setScoreAvg(double scoreAvg) {
        this.scoreAvg = scoreAvg;
    }
}
