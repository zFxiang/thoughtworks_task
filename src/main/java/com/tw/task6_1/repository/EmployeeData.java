package com.tw.task6_1.repository;

import com.tw.task6_1.entity.Employee;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
@Repository
public class EmployeeData {
    private AtomicLong IDSeq = new AtomicLong(0);
    private ConcurrentHashMap<Long,Employee> data = new ConcurrentHashMap<>();
    public void add(Employee employee){
        employee.setId(IDSeq.incrementAndGet());
        data.put(employee.getId(),employee);
    }
    public boolean update(Employee employee){
        if(data.get(employee.getId()) != null){
            data.put(employee.getId(),employee);
            return true;
        }
        return false;
    }
    public boolean remove(Long id){
        return data.remove(id) != null;
    }
    public Employee get(Long id){
        return data.get(id);
    }
    public List<Employee> list(){
        return data.keySet().stream().sorted().map(data::get).collect(Collectors.toList());
    }
}
