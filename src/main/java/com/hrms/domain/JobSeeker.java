package com.hrms.domain;


import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker")
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String personalId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
	@Column(nullable = false, updatable = false)
	private LocalDate birth;
	
	@Email(message = "Please provide a email adress")
	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String email;
	
	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String password;
	
	@Column(nullable = false)
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
