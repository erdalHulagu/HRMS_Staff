package com.hrms.domain;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "tb_job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Column(name = "company_name", nullable = false)
//	@NotNull
//	@NotBlank
//	private String companyName;
	
	
	
	@Column(name = "job_name", nullable = false)
	@NotNull
	@NotBlank
	private String jobName;
	
	
	@Column(name = "job_quantity")
	@NotNull
	private int quantity;
	
	@Column(name = "job_description")
	@NotNull
	private String description;
	
	
	@OneToOne(mappedBy = "job")
    private Employer employer;
	
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "job_application",
        joinColumns = @JoinColumn(name = "job_id"),
        inverseJoinColumns = @JoinColumn(name = "job_seeker_id")
    )
    private List<JobSeeker> jobSeekers;
	
	
	

}
