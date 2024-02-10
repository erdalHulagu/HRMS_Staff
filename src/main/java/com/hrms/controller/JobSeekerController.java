package com.hrms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.DTO.JobDTO;
import com.hrms.DTO.JobSeekerDTO;
import com.hrms.Message.ResponseMessage;
import com.hrms.domain.Job;
import com.hrms.domain.JobSeeker;
import com.hrms.request.JobSeekerRequest;
import com.hrms.response.Response;
import com.hrms.service.JobSeekerService;

@RestController
@RequestMapping("/jobSeekers")
public class JobSeekerController {
	
	private JobSeekerService jobSeekerService;

	public JobSeekerController(JobSeekerService jobSeekerService) {
		
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("/createJobSeeker")
	public ResponseEntity<Response> createJobSeeker(@RequestBody JobSeeker jobSeeker ){
		
		
		
		jobSeekerService.createJobSeeker(jobSeeker);
	
	Response response = new Response();
	response.setMessage(ResponseMessage.JOBSEEKER_CREATED);
	response.setSuccess(true);
	
	return ResponseEntity.ok(response);
	
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<JobSeekerDTO> getJobSeekerById(@PathVariable Long id){
		
		JobSeekerDTO jobSeekerDTO=	jobSeekerService.findJobSeekerById(id);
		
	return ResponseEntity.ok(jobSeekerDTO);
	}

	
	
	@GetMapping("/all")
	public ResponseEntity<List<JobSeekerDTO>> getAll(){
		
		List<JobSeekerDTO> jobSeekerDTO=	jobSeekerService.findAllJobSeekers();
		
		return ResponseEntity.ok(jobSeekerDTO);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id){
		
		jobSeekerService.deleteJobSeekerById(id);
		
Response response=new Response();
response.setMessage(ResponseMessage.JOBSEEKER_DELETED);
response.setSuccess(true);


		return ResponseEntity.ok(response);
	}
	@DeleteMapping("deleteAll")
	public ResponseEntity<Response> deleteJodById(){
		
		jobSeekerService.deleteAllJobs();
		
		Response response=new Response();
		response.setMessage(ResponseMessage.ALL_JOBSEEKERS_DELETED);
		response.setSuccess(true);
		
		
		return ResponseEntity.ok(response);
	}
	
	
	@PatchMapping("/upDate/{id}")
	public ResponseEntity<JobSeekerRequest> updateJob( @RequestBody JobSeekerRequest jobSeekerRequest, @PathVariable Long id ){
		
		JobSeekerRequest jobSeeker=jobSeekerService.updateJobSeeker(jobSeekerRequest,id);
		
		return ResponseEntity.ok(jobSeeker);  
		
	}

}
