package com.hrms.DTO;


import java.util.List;

import com.hrms.domain.Job;
import com.hrms.domain.JobSeeker;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
public class EmployerDTO {
	
	
	@NotBlank
	@NotNull
	private String companyName;
	
	@Email(message = "Please provide a email adress")
	@NotBlank
	@NotNull
	private String email;
	
	@NotBlank
	@NotNull
	private String password;
	
	@NotBlank
	@NotNull
	private String phone;
	
	@NotBlank
	@NotNull
	private String webside;
	
	
	   
	
	
	
	
	
	

}
