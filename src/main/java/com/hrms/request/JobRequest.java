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
	
	
	
	private String jobName;
	
	private String companyName;
	
    private int quantity;
	
	private String description;
	
    private Employer employer;
    
    private int maxPrice;
    
    private int minPrice;

    private Set<JobSeeker> jobSeekers;
	
	
	

}
