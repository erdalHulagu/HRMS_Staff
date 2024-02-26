package com.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.DTO.JobDTO;
import com.hrms.domain.Employer;
import com.hrms.domain.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

	@Query("SELECT * j From Job j WHERE j.employer=:employer")
	List<Job> findJobByEmployer(Employer employer);

	

}
