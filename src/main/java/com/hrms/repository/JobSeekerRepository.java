package com.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.domain.Job;
import com.hrms.domain.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>{

//	@Query("SELECT j FROM tb_jobSeeker j WHERE j.email = :email")
	Optional<JobSeeker> getByEmail(String email);

	
}
