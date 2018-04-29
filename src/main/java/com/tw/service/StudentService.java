package com.tw.service;

import com.tw.data.StudentData;
import com.tw.model.Student;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private final static StudentService INSTANT = new StudentService();
    private StudentData studentData = StudentData.getInstant();

    public static StudentService getInstant(){
        return INSTANT;
    }
    public void save(Student student) {
        Map<String, Double> score = student.getScore();
        DoubleSummaryStatistics statistics = score.keySet().stream().mapToDouble(score::get).summaryStatistics();
        student.setScoreTotal(statistics.getSum());
        student.setScoreAvg(statistics.getAverage());
        studentData.saveOrUpdate(student);
    }
    public void printScore(List<String> nos) {
        System.out.println("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================");
        nos.stream().map(studentData::getByNo).forEach(student -> {
            if(student == null){
                return;
            }
            Map<String, Double> scoreMap = student.getScore();
            System.out.printf("%s|%.2f|%.2f|%.2f|%.2f|%.2f|%.2f\n",
                    student.getName(),
                    scoreMap.get("数学"),
                    scoreMap.get("语文"),
                    scoreMap.get("英语"),
                    scoreMap.get("编程"),
                    student.getScoreAvg(),
                    student.getScoreTotal()
            );
        });
        System.out.println("========================");
        List<Student> list = studentData.list();
        double avg = list.stream().mapToDouble(Student::getScoreTotal).average().orElse(0.0);
        List<Double> collect = list.stream().mapToDouble(Student::getScoreTotal).sorted().boxed().collect(Collectors.toList());
        double middle = 0.0;
        int size = collect.size();
        if(size % 2 != 0){
            middle = collect.get(size/2);
        }else if(size != 0){
            middle = (collect.get(size/2 - 1) + collect.get(size/2)) / 2;
        }
        System.out.printf("全班总分平均数：%.2f\n",avg);
        System.out.printf("全班总分中位数：%.2f\n",middle);
    }
}