package com.hrms.domain;

	import java.util.Set;
	
	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.ManyToOne;
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
	 @Table(name = "tb_emloyee")
	 public class Employee {
	 	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.AUTO)
	 	private Long id;
	 	
	 	@Column(nullable = false)
	 	@NotBlank
	 	@NotNull
	 	private String employeeFirstName;
	 	
	 	@Column(nullable = false)
	 	@NotBlank
	 	@NotNull
	 	private String employeeLastName;
	 	
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
	 	
	 	@ManyToOne(targetEntity = Job.class,cascade = CascadeType.ALL)
	 	private Set<Job> jobs;
	 	
	 }
