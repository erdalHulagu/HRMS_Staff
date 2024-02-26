package com.hrms.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.hrms.DTO.JobSeekerDTO;
import com.hrms.Message.ErrorMessage;
import com.hrms.domain.JobSeeker;
import com.hrms.exeption.BadRequestException;
import com.hrms.exeption.ConflictException;
import com.hrms.exeption.ResourceNotFoundException;
import com.hrms.repository.JobSeekerRepository;
import com.hrms.request.JobSeekerRequest;
import com.hrms.request.LoginRequest;

@Service
public class JobSeekerService {
	
	private JobSeekerRepository jobSeekerRepository;
	
	
	
	public JobSeekerService(JobSeekerRepository jobSeekerRepository) {
		
		this.jobSeekerRepository=jobSeekerRepository;
		
	}

	//--------------------------
	public void createJobSeeker(JobSeeker jobSeeker) {
		
	boolean isEqual=jobSeeker.getPassword().equals(jobSeeker.getReTypePassword());
				
		if (!isEqual) {
			
			throw new BadRequestException(ErrorMessage.PASSWORD_NOT_MUCH);
			
		}
		
		
	List<JobSeeker> jobSeekers=	getAll();
	
	boolean exists = jobSeekers.stream()
            .anyMatch(jobSkr -> jobSkr.getPersonalId().equals(jobSeeker.getPersonalId())
            		         || jobSkr.getEmail().equals(jobSeeker.getEmail()));

       if (exists) {
       throw new ConflictException(ErrorMessage.JOBSEEKER_ALREADY_EXIST);
    }
      
		
		jobSeekerRepository.save(jobSeeker);
		
	}


	//--------------------------
	public JobSeekerDTO findJobSeekerById(Long id) {
	JobSeeker jobSeeker=	getJobSeekerById(id);
	
	JobSeekerDTO jobSeekerDTO=new JobSeekerDTO();
	
	jobSeekerDTO.setFirstName(jobSeeker.getFirstName());
	jobSeekerDTO.setLastName(jobSeeker.getLastName());
	jobSeekerDTO.setBirth(jobSeeker.getBirth());
	jobSeekerDTO.setPersonalId(jobSeeker.getPersonalId());
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
	public void deleteAllJobSeekers() {
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
//			                                     , jobSeeker.getPersonalId()
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
                                                            , jobSeeker.getPersonalId()
                                                            , jobSeeker.getEmail()
                                                            , jobSeeker.getPassword()
                                                            , jobSeeker.getPhone()
                                                            , jobSeeker.getWebside());
	                                                          jobSDtos.add(jobSeekerDTO);
	     }
		
		return jobSDtos;
		
	}

	public JobSeekerRequest updateJobSeeker(JobSeekerRequest jobSeekerRequest, Long id) {
		 
		JobSeeker jobSeeker =	getJobSeekerById(id);

		jobSeeker.setFirstName(jobSeekerRequest.getFirstName());
		jobSeeker.setLastName(jobSeekerRequest.getLastName());
		jobSeeker.setBirth(jobSeekerRequest.getBirth());
		jobSeeker.setPersonalId(jobSeekerRequest.getPersonalId());
		jobSeeker.setEmail(jobSeekerRequest.getEmail());
		jobSeeker.setPassword(jobSeekerRequest.getPassword());
		jobSeeker.setPhone(jobSeekerRequest.getPhone());
		jobSeeker.setWebside(jobSeekerRequest.getWebside());

		jobSeekerRepository.save(jobSeeker);

				return jobSeekerRequest;
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

		public JobSeekerDTO getByEmail(LoginRequest loginRequest) {
//			List<JobSeeker> jobSeekers= getAll();
//			if (jobSeekers.stream().anyMatch(jsk->jsk.getEmail().equals(loginRequest.getEmail())));
//				
		JobSeeker jobSeeker=	
				            jobSeekerRepository.findByEmail(
				            		loginRequest.getEmail()).orElseThrow(
				            				()->new ResourceNotFoundException(
				            						String.format(
				            								ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, loginRequest.getEmail())));
		
		if (!jobSeeker.getPassword().equals(loginRequest.getPassword())) {
			throw new BadRequestException(String.format(ErrorMessage.PASSWORD_NOT_MUCH, loginRequest.getPassword()));
		}
			
			
		
			
		
			JobSeekerDTO jobSeekerDTO=new JobSeekerDTO();
			jobSeekerDTO.setEmail(jobSeeker.getEmail());
			jobSeekerDTO.setPassword(jobSeeker.getPassword());
			jobSeekerDTO.setBirth(jobSeeker.getBirth());
			jobSeekerDTO.setFirstName(jobSeeker.getFirstName());
			jobSeekerDTO.setLastName(jobSeeker.getLastName());
			jobSeekerDTO.setPersonalId(jobSeeker.getPersonalId());
			jobSeekerDTO.setPhone(jobSeeker.getPhone());
			jobSeekerDTO.setWebside(jobSeeker.getWebside());
			
			return jobSeekerDTO;
		}

		
			
		

}
