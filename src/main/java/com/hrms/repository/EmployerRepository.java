package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.domain.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long>{

}
