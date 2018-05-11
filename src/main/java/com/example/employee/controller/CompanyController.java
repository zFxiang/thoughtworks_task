package com.example.employee.controller;

import com.example.employee.entity.Company;
import com.example.employee.entity.Employee;
import com.example.employee.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("")
    public List<Company> list(){
        return companyRepository.findAll();
    }
    @GetMapping("/page/{page}/pageSize/{size}")
    public Page<Company> listPage(@PathVariable Integer page, @PathVariable Integer size){
        return companyRepository.findAll(PageRequest.of(page,size));
    }
    @GetMapping("/{id}")
    public Company get(@PathVariable Integer id){
        return companyRepository.findById(id).orElse(null);
    }
    @GetMapping("/{id}/employees")
    public List<Employee> getEmployees(@PathVariable Integer id){
        return companyRepository.findById(id).orElse(new Company()).getEmployees();
    }
    @PostMapping("")
    public Company add(Company company){
        return companyRepository.save(company);
    }
    @PutMapping("/{id}")
    public Company update(@PathVariable Integer id, Company company){
        company.setId(id);
        return companyRepository.save(company);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        companyRepository.deleteById(id);
    }
}
