package com.hrms.domain;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.apache.coyote.BadRequestException;
import org.springframework.format.annotation.DateTimeFormat;

import com.hrms.Message.ResponseMessage;
import com.hrms.response.Response;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "tb_employer")
public class Employer {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String companyName;
	
	@Email(message = "Please provide a email adress")
	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String email;
	
	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column
	private LocalDateTime createTime;
	
	@Column(nullable = false)
	@NotBlank
	@NotNull
	private String reTypePassword;
	
	
	@Column(nullable = false)
	@NotBlank
	@NotNull
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}",	// 999-999-9999
	message = "Please provide valid phone number" ) 
	private String phone;
	
	@Column(nullable = false,name = "companys_webside")
	@NotBlank
	@NotNull
	private String webside;
	
	
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Job> jobs;
	
	@OneToMany(targetEntity = JobSeeker.class, cascade = CascadeType.ALL)
	private List<JobSeeker> jobSeeker;
	
	
	private boolean built;
	

	public Employer() {
		this.createTime=LocalDateTime.now();
		
	}
//	   
//	 public void setWeb(String webside) throws BadRequestException  {
//	        if (webside.startsWith("www.")) {
//	            
//	        	this.webside = webside;
//	        	
//	        } else {
//	        	
//	        	throw new BadRequestException(ResponseMessage.SET_WWW);
//	        	
//	        }
//		
//	
//	 }
	
	
	

}
