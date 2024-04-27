package com.hrms.controller;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.DTO.EmployerDTO;
import com.hrms.DTO.JobDTO;
import com.hrms.Message.ResponseMessage;
import com.hrms.domain.Employer;
import com.hrms.domain.Job;
import com.hrms.request.EmployerRequest;
import com.hrms.response.Response;
import com.hrms.service.EmployerService;
import com.hrms.service.JobService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/employers")
public class EmployerController {
	
	private EmployerService employerService;
	
	private JobService jobService;
	
	public EmployerController(EmployerService employerService,
			                  JobService jobService
			                  ) {
		this.employerService=employerService;
		this.jobService=jobService;
		
	}

	@PostMapping("/createEmployer")
	public ResponseEntity<Response> createEmployer(@RequestBody Employer employer ){
		
		
		
		employerService.createEmployer(employer);
	
	Response response = new Response();
	response.setMessage(ResponseMessage.EMPLOYER_CREATED);
	response.setSuccess(true);
	
	return ResponseEntity.ok(response);
	
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployerDTO> getJobSeekerById(@PathVariable Long id){
		
		EmployerDTO employerDTO=	employerService.findEmployerById(id);
		
	return ResponseEntity.ok(employerDTO);
	}

	
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployerDTO>> getAll(){
		
	    List<EmployerDTO> employerDTOs = employerService.getAllEmployers();
	 
	    return ResponseEntity.ok(employerDTOs);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id){
		
		employerService.deleteEmployerById(id);
		
Response response=new Response();
response.setMessage(ResponseMessage.JOBSEEKER_DELETED);
response.setSuccess(true);


		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/deleteAll")
	public ResponseEntity<Response> deleteEmployerById(){
		
		employerService.deleteAllEmplloyers();
		
		Response response=new Response();
		response.setMessage(ResponseMessage.ALL_JOBSEEKERS_DELETED);
		response.setSuccess(true);
		
		
		return ResponseEntity.ok(response);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateJob( @RequestBody EmployerRequest employerRequest, @PathVariable Long id ){
		
		employerService.updateEmployer(employerRequest,id);
		

		Response response = new Response();
		response.setMessage(ResponseMessage.EMPLOYER_UPDATED);
		response.setSuccess(true);
		
		return ResponseEntity.ok(response);  
		
	}
//	
//	@PostMapping("/employerJob/{employerId}")
//	 public ResponseEntity<Job> createJobByEmployer(@RequestBody Job job, @PathVariable  Long employerId){
//		
//	Job jb=employerService.createJobByEmployer(job,employerId);
//		
//		
//		return ResponseEntity.ok(jb);
//		
//		
//	}
	@PostMapping("/employerJob/{employerId}")
	public ResponseEntity<Response> createJobByEmployer(@RequestBody Job job, @PathVariable  Long employerId){
		
		employerService.createJobByEmployer(job,employerId);
		
		
		Response response = new Response();
		response.setMessage(ResponseMessage.JOB_CREATED);
		response.setSuccess(true);
		
		return ResponseEntity.ok(response);  
		
		
		
	}
	 @GetMapping("/{employerId}")
	    public ResponseEntity<List<Job>> getAllJobsByEmployer(@PathVariable Long employerId) {
	        List<Job> jobs = jobService.getAllJobsByEmployer(employerId);
	        return ResponseEntity.ok(jobs);
	    }
	
	

}

