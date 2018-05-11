package com.example.employee.repository;

import com.example.employee.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{

}
