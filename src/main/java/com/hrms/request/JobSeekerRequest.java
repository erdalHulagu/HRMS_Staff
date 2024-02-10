package com.hrms.request;


import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrms.domain.Job;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
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
public class JobSeekerRequest {

	
	@NotBlank
	@NotNull
	private String firstName;
	
	@NotBlank
	@NotNull
	private String lastName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate birth;
	
	@NotBlank
	@NotNull
	private String personalId;
	
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
	
	@Column(nullable = false,name = "companys_webside")
	@NotBlank
	@NotNull
	private String webside;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private List<Job> jobs;
	
	@ManyToMany(mappedBy = "jobSeekers")
	private List<Job> appliedJobs;
	
	
	

}
