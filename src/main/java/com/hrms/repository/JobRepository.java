package com.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hrms.DTO.JobDTO;
import com.hrms.domain.Employer;
import com.hrms.domain.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

	@Query("SELECT j FROM Job j WHERE j.employer.id = :employerId")
	List<Job> findJobByEmployer(@Param("employerId") Long employerId);

	
//
//	@Query("SELECT j FROM Job j WHERE j.jobSeeker.id =:id")
//	List<Job> findJobsByJobSeekerId(@Param("id") Long id);

	@Query("SELECT j FROM Job j JOIN j.jobSeekers js WHERE js.id = :id")
	List<Job> findJobsByJobSeekerId(@Param("id") Long id);

	

}
