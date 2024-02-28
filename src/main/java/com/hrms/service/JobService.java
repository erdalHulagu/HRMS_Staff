package com.hrms.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.LayoutFocusTraversalPolicy;

import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.hrms.DTO.JobDTO;
import com.hrms.Message.ErrorMessage;
import com.hrms.domain.Employer;
import com.hrms.domain.Job;
import com.hrms.domain.JobSeeker;
import com.hrms.exeption.ConflictException;
import com.hrms.exeption.ResourceNotFoundException;
import com.hrms.repository.JobRepository;
import com.hrms.repository.JobSeekerRepository;
import com.hrms.request.JobRequest;
import com.hrms.response.Response;

@Service
public class JobService {
	
	
	private JobRepository jobRepository;
	
	private JobSeekerRepository jobSeekerRepository;
	
	private  JobSeekerService jobSeekerService;
	
	private EmployerService employerService;
	

	public JobService(JobRepository jobRepository,
			          JobSeekerRepository jobSeekerRepository,
			          JobSeekerService jobSeekerService,
			          @Lazy EmployerService employerService) {
	
		this.jobRepository = jobRepository;
		this.jobSeekerRepository=jobSeekerRepository;
		this.jobSeekerService=jobSeekerService;
		this.employerService=employerService;
		
		
	}


	//--------------------------
	public void createJob(Job job) {
	List<Job> jobs	=getAll();
	
//	boolean isMuch =jobs.stream().anyMatch(jb->jb.getJobName().equals(job.getJobName()));
//	
//	if (isMuch) {
//		throw new ConflictException(String.format(ErrorMessage.NAME_CONFLICT, job.getJobName()));
//	}
//	
		jobRepository.save(job);
		
			
	
		
	}
	public Job createJobByEmployer(Job job) {
		List<Job> jobs	=getAll();
		
		boolean isMuch =jobs.stream().anyMatch(jb->jb.getJobName().equals(job.getJobName()));
		
		if (isMuch) {
			throw new ConflictException(String.format(ErrorMessage.NAME_CONFLICT, job.getJobName()));
		}
		
			Job empJob =jobRepository.save(job);
			return empJob;
			
	}

	//--------------------------
	public JobDTO findJobById(Long id) {
		
	Job job=getById(id);	
	
			JobDTO jobDTO=new JobDTO();
		
		jobDTO.setJobName(job.getJobName());
		jobDTO.setDescription(job.getDescription());
		jobDTO.setQuantity(job.getQuantity());
		jobDTO.setCompanyName(job.getCompanyName());
		jobDTO.setMaxPrice(job.getMaxPrice());
		jobDTO.setMinPrice(job.getMinPrice());
		
	
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
	            JobDTO jobDTO = new JobDTO(job.getCompanyName(),
	            		                   job.getQuantity(),
	            		                   job.getJobName(),
	            		                   job.getDescription(),
	            		                   job.getMaxPrice(),
	            		                   job.getMinPrice());
	            jobDTOs.add(jobDTO);
	        }
		
		return jobDTOs;
		
		
	}




	//--------------------------
	public JobRequest updateJob (JobRequest jobRequest, Long id) {
		
		Job job =	getById(id);

       job.setJobName(jobRequest.getJobName());
       job.setCompanyName(jobRequest.getCompanyName());
       job.setDescription(jobRequest.getDescription());
       job.setQuantity(jobRequest.getQuantity());
       job.setMaxPrice(jobRequest.getMaxPrice());
       job.setMinPrice(jobRequest.getMinPrice());

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


	public void applyForJob(Long JobSeekerid, Long jobId) {
		
		JobSeeker jobSeeker=jobSeekerService.getJobSeekerById(JobSeekerid);
		
		 Job job  =getById(jobId);
		
		job.getJobSeekers().add(jobSeeker);
		
		jobRepository.save(job);
		
		
		
	}



	 public List<Job> getAllJobsByEmployer(Long employerId) {
	        Employer employer = employerService.getEmployerById(employerId);

	       
	       
	      return   jobRepository.findJobByEmployer(employer.getId());

	 }
	


	


	
	



	

}
