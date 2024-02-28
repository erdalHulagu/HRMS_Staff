package com.hrms.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.yaml.snakeyaml.constructor.Constructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.DTO.JobDTO;

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
@Table(name = "tb_job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Column(name = "company_name", nullable = false)
//	@NotNull
//	@NotBlank
	private String companyName;
	
	
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
	@Column
    private int maxPrice;
	
    @Column
	private int minPrice;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column
	private LocalDateTime createTime;
	

	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;
	
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "job_application",
        joinColumns = @JoinColumn(name = "job_id"),
        inverseJoinColumns = @JoinColumn(name = "job_seeker_id")
    )
    private List<JobSeeker> jobSeekers;
	
	
	public Job() {
		this.createTime=LocalDateTime.now();
	}


	
}
