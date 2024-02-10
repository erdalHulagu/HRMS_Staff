package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.DTO.JobDTO;
import com.hrms.domain.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

	

}
