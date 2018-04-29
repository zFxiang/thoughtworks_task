package com.tw.data;

import com.tw.model.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StudentData {
    private final static StudentData INSTANT = new StudentData();
    private Map<String,Student> data = new ConcurrentHashMap<>();
    private List<String> order = new LinkedList<>();

    public static StudentData getInstant(){
        return INSTANT;
    }

    public Student getByNo(String no){
        return data.get(no);
    }
    public void saveOrUpdate(Student student){
        String no = student.getNo();
        if(no == null || "".equals(no)){
            throw new IllegalArgumentException("学号不能为空！");
        }
        if(data.get(no) == null){
            order.add(no);
        }
        data.put(no,student);
    }
    public List<Student> list(){
        return order.stream().map(data::get).collect(Collectors.toList());
    }
}
