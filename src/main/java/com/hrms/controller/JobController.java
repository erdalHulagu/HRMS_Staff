package com.hrms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.DTO.JobDTO;
import com.hrms.Message.ResponseMessage;
import com.hrms.domain.Job;
import com.hrms.request.JobRequest;
import com.hrms.response.Response;
import com.hrms.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	
	private JobService jobService;
	
	
	public JobController(JobService jobService) {
		
		this.jobService=jobService;
	}
	
	@PostMapping("/createJob")
	public ResponseEntity<Response> createJob(@RequestBody Job job ){
		
		
		
		jobService.createJob(job);
	
	Response response = new Response();
	response.setMessage(ResponseMessage.JOB_CREATED);
	response.setSuccess(true);
	
	return ResponseEntity.ok(response);
	
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<JobDTO> getJobById(@PathVariable Long id){
		
	JobDTO jobDTO=	jobService.findJobById(id);
		
	return ResponseEntity.ok(jobDTO);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<JobDTO>> getAllJobs(){
		
		List<JobDTO> jobDTO=	jobService.findAllJobs();
		
		return ResponseEntity.ok(jobDTO);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Response> deleteJodById(@PathVariable Long id){
		
		jobService.deleteJobById(id);
		
Response response=new Response();
response.setMessage(ResponseMessage.JOB_DELETED);
response.setSuccess(true);


		return ResponseEntity.ok(response);
	}
	@DeleteMapping("deleteAll")
	public ResponseEntity<Response> deleteJodById(){
		
		jobService.deleteAllJobs();
		
		Response response=new Response();
		response.setMessage(ResponseMessage.ALL_JOBS_DELETED);
		response.setSuccess(true);
		
		
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/upDate/{id}")
	public ResponseEntity<JobRequest> updateJob( @RequestBody JobRequest jobRequest, @PathVariable Long id ){
		
		JobRequest job=jobService.updateJob(jobRequest,id);
		
		return ResponseEntity.ok(job);  
		
	}

}
//{
//"firstName":"Ali",
//"lastName":"Ali",
//"birth": "1990-01-04",
//"email":"ali@ali.com",
//"password":"password",
//"phone":"7586654863",
//"webside":"www.ali.com"
//}
