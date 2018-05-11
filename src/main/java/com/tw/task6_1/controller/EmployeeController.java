package com.tw.task6_1.controller;

import com.tw.task6_1.entity.Employee;
import com.tw.task6_1.repository.EmployeeData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeData employeeData;

    @GetMapping("")
    public List<Employee> list(){
        return employeeData.list();
    }
    @GetMapping("/{empId}")
    public Employee get(@PathVariable("empId") Long empId){
        return employeeData.get(empId);
    }
    @PostMapping("")
    public boolean add(Employee employee){
        employeeData.add(employee);
        return true;
    }
    @PostMapping("/{empId}")
    public boolean update(@PathVariable("empId") Long empId,Employee employee){
        employee.setId(empId);
        return employeeData.update(employee);
    }
    @DeleteMapping("/{empId}")
    public boolean remove(@PathVariable("empId") Long empId){
        return employeeData.remove(empId);
    }
}
