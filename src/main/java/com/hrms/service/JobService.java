package com.hrms.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.LayoutFocusTraversalPolicy;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.hrms.DTO.JobDTO;
import com.hrms.Message.ErrorMessage;
import com.hrms.domain.Job;
import com.hrms.exeption.ResourceNotFoundException;
import com.hrms.repository.JobRepository;
import com.hrms.request.JobRequest;
import com.hrms.response.Response;

@Service
public class JobService {
	
	
	private JobRepository jobRepository;
	
	

	public JobService(JobRepository jobRepository) {
	
		this.jobRepository = jobRepository;
	}


	//--------------------------
	public void createJob(Job job) {
		
		jobRepository.save(job);
		
	}


	//--------------------------
	public JobDTO findJobById(Long id) {
		
	Job job=getById(id);	
	
			JobDTO jobDTO=new JobDTO();
		
		jobDTO.setName(job.getName());
	
	return jobDTO;
		
	}


	//--------------------------
	public List<JobDTO> findAllJobs() {
		List<Job> jobs=	jobRepository.findAll();
			
		
		//With using Lambda stream
		//
//			List<JobDTO> jobDTOs = new ArrayList<>();
//	        jobs.stream()
//	            .map(job -> new JobDTO(job.getName()))
//	            .forEach(jobDTOs::add);
	        
	        List<JobDTO> jobDTOs = new ArrayList<>();

	       
	        for (Job job : jobs) {
	            JobDTO jobDTO = new JobDTO(job.getName());
	            jobDTOs.add(jobDTO);
	        }
		
		return jobDTOs;
		
		
	}




	//--------------------------
	public JobRequest updateJob (JobRequest jobRequest, Long id) {
		
		Job job =	getById(id);

job.setName(jobRequest.getName());

jobRepository.save(job);

		return jobRequest;
	}


	//--------------------------
	public void deleteJobById(Long id) {
			
			jobRepository.deleteById(id);
	
	}
	//--------------------------
       public void deleteAllJobs() {

    	   jobRepository.deleteAll();
    	   
    	   
 //-----------alttaki methodda delete all olarak kullanilabilir
    	   
//    		List<Job> jobs	=getAll();
    	//	
//    	    	   jobs.stream()
//    	           .map(job -> job.getId())
//    	           .forEach(id->deleteJobById(id));
		
		
	}
	
       
       
       
	//-----Method FindById ------
	public Job getById(Long id) {
		
		Job job =	jobRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));

		return job;
	}



	
	//-----Method getAll ------
	public List<Job> getAll(){
		List<Job> jobs=	jobRepository.findAll();
		return jobs;
	}
	
	



	


	
	



	

}
