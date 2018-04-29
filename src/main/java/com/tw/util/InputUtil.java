package com.tw.util;

import com.tw.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputUtil {
    private static Pattern patternForAddStu = Pattern.compile("^[^,]+, [^,]+(, [^,]+: \\d+){4}$");
    public static Student parseStudent(String str){
        if (!patternForAddStu.matcher(str).find()) {
            return null;
        }
        try {
            Student student = new Student();
            Map<String, Double> scoreMap = student.getScore();
            String[] split = str.split(",");
            student.setName(split[0].trim());
            student.setNo(split[1].trim());
            for (int i = 2; i < split.length; i++) {
                String courseInfo = split[i];
                String[] courseSplit = courseInfo.split(":");
                scoreMap.put(courseSplit[0].trim(),Double.valueOf(courseSplit[1]));
            }
            return student;
        } catch (NumberFormatException e) {
            return null;
        }
    }
    private static Pattern patternForNos = Pattern.compile("^[^,]+(, [^,]+)*$");
    public static List<String> parseNos(String str) {
        if (!patternForNos.matcher(str).find()) {
            return null;
        }
        String[] split = str.split(",");
        return Arrays.stream(split).map(String::trim).collect(Collectors.toList());
    }
}
