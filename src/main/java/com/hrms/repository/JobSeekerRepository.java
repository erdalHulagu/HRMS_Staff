package com.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.domain.Job;
import com.hrms.domain.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>{


//	 getByEmail(String email);

	@Query("SELECT j FROM JobSeeker j WHERE j.email = :email")
	Optional<JobSeeker> findByEmail(String email);

	
}
