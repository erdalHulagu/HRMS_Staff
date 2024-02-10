package com.hrms.request;

import java.util.Set;

import com.hrms.domain.Employer;
import com.hrms.domain.JobSeeker;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobRequest {
	
	
	
	private String name;
	
	
    private Employer employer;

	
    
    private Set<JobSeeker> jobSeekers;
	
	
	

}
