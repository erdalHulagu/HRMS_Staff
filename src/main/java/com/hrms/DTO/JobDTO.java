package com.hrms.DTO;





import java.util.List;
import java.util.Set;

import com.hrms.domain.Employer;
//import com.hrms.domain.JobSeeker;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
public class JobDTO {
	

	
	@NotNull
	@NotBlank
	private String name;
	
	private int quantity;
	
	private String description;
	
	
//    private Employer employer;

	
//    private Set<JobSeeker> jobSeekers;


	
	
	
	

}


