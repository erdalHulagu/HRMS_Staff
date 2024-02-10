package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.domain.Job;
import com.hrms.domain.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>{

	void save(Job job);

}
