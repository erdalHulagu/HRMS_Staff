package com.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.DTO.JobDTO;
import com.hrms.DTO.JobSeekerDTO;
import com.hrms.Message.ErrorMessage;
import com.hrms.domain.Job;
import com.hrms.domain.JobSeeker;
import com.hrms.exeption.ResourceNotFoundException;
import com.hrms.repository.JobSeekerRepository;
import com.hrms.request.JobSeekerRequest;

@Service
public class JobSeekerService {
	
	
	private JobSeekerRepository jobSeekerRepository;
	
	
	public JobSeekerService(JobSeekerRepository jobSeekerRepository) {
		
		this.jobSeekerRepository=jobSeekerRepository;
		
	}

	//--------------------------
	public void createJobSeeker(JobSeeker jobSeeker) {
		
		jobSeekerRepository.save(jobSeeker);
		
	}
	//--------------------------
	public JobSeekerDTO findJobSeekerById(Long id) {
	JobSeeker jobSeeker=	getJobSeekerById(id);
	
	JobSeekerDTO jobSeekerDTO=new JobSeekerDTO();
	
	jobSeekerDTO.setFirstName(jobSeeker.getFirstName());
	jobSeekerDTO.setLastName(jobSeeker.getLastName());
	jobSeekerDTO.setBirth(jobSeeker.getBirth());
	jobSeekerDTO.setEmail(jobSeeker.getEmail());
	jobSeekerDTO.setPassword(jobSeeker.getPassword());
	jobSeekerDTO.setPhone(jobSeeker.getPhone());
	jobSeekerDTO.setWebside(jobSeeker.getWebside());
	
		return jobSeekerDTO;
	}
	
	//--------------------------
	public void deleteJobSeekerById(Long id) {
		
		jobSeekerRepository.deleteById(id);
	
	
		
	}

	//--------------------------
	public void deleteAllJobs() {
		jobSeekerRepository.deleteAll();
		
	}

	//--------------------------
	public List<JobSeekerDTO> findAllJobSeekers() {
		
		List<JobSeeker> jobSeekers=	jobSeekerRepository.findAll();
		
		
			List<JobSeekerDTO> jobSDtos = new ArrayList<>();
//			jobSeekers.stream()
//	            .map(jobSeeker -> new JobSeekerDTO(null
//	            		                         , jobSeeker.getFirstName()
//	            		                         , jobSeeker.getLastName()
//	            		                         , jobSeeker.getBirth()
//	            		                         , jobSeeker.getEmail()
//	            		                         , jobSeeker.getPassword()
//	            		                         , jobSeeker.getPhone()
//	            		                         , jobSeeker.getWebside()
//	            		                         , null))
//	            .forEach(jobSDtos::add);
//	        
//	        List<JobSeekerDTO> jobSDtos = new ArrayList<>();

	       
	        for (JobSeeker jobSeeker : jobSeekers) {
	            JobSeekerDTO jobSeekerDTO = new JobSeekerDTO(
	            		                                      jobSeeker.getFirstName()
                                                            , jobSeeker.getLastName()
                                                            , jobSeeker.getBirth()
                                                            , jobSeeker.getEmail()
                                                            , jobSeeker.getPassword()
                                                            , jobSeeker.getPhone()
                                                            , jobSeeker.getWebside());
	                                                          jobSDtos.add(jobSeekerDTO);
	     }
		
		return jobSDtos;
		
	}

	
	

	// -------- METHOD getJobSeekerById
		public JobSeeker  getJobSeekerById (Long id) {
			
			JobSeeker jobSeeker =	jobSeekerRepository.findById(id)
	                .orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));

			return jobSeeker;
			
		}
		
    // -----Method getAll ------
		public List<JobSeeker> getAll(){
			List<JobSeeker> jobs=	jobSeekerRepository.findAll();
			return jobs;
		}

		public JobSeekerRequest updateJobSeeker(JobSeekerRequest jobSeekerRequest, Long id) {
			 
			JobSeeker jobSeeker =	getJobSeekerById(id);

			jobSeeker.setFirstName(jobSeekerRequest.getFirstName());
			jobSeeker.setLastName(jobSeekerRequest.getLastName());
			jobSeeker.setBirth(jobSeekerRequest.getBirth());
			jobSeeker.setEmail(jobSeekerRequest.getEmail());
			jobSeeker.setPassword(jobSeekerRequest.getPassword());
			jobSeeker.setPhone(jobSeekerRequest.getPhone());
			jobSeeker.setWebside(jobSeekerRequest.getWebside());

			jobSeekerRepository.save(jobSeeker);

					return jobSeekerRequest;
				}
			
		

}
