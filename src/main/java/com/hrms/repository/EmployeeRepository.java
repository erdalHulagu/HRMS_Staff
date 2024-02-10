package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
