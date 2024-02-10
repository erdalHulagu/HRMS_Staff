package com.hrms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.DTO.EmployerDTO;
import com.hrms.DTO.JobSeekerDTO;
import com.hrms.Message.ErrorMessage;
import com.hrms.domain.Employee;
import com.hrms.domain.Employer;
import com.hrms.domain.JobSeeker;
import com.hrms.exeption.BadRequestException;
import com.hrms.exeption.ConflictException;
import com.hrms.exeption.ResourceNotFoundException;
import com.hrms.repository.EmployerRepository;
import com.hrms.request.EmployerRequest;

@Service
public class EmployerService {
	
	
	private EmployerRepository employerRepository;
	

	public EmployerService(EmployerRepository employerRepository) {
		
		this.employerRepository = employerRepository;
	}

//------------------------
	public void createEmployer(Employer employer) {
boolean isEqual=employer.getPassword().equals(employer.getReTypePassword());
		
		if (!isEqual) {
			
			throw new BadRequestException(ErrorMessage.PASSWORD_NOT_MUCH);
			
		}
		
		
	List<Employer> employers= getAll();
	
	boolean exists = employers.stream()
            .anyMatch(emplyr -> emplyr.getEmail().equals(employer.getEmail()));
            		        

       if (exists) {
       throw new ConflictException(ErrorMessage.EMPLOYER_ALREADY_EXIST);
    }
      
		
		employerRepository.save(employer);
		
	}


	//--------------------------
	public EmployerDTO findEmployerById(Long id) {
		
			Employer employer=getEmployerById(id);
			
			EmployerDTO employerDTO=new EmployerDTO();
		
			employerDTO.setCompanyName(employer.getCompanyName());
			employerDTO.setEmail(employer.getEmail());
			employerDTO.setPassword(employer.getPassword());
			employerDTO.setPhone(employer.getPhone());
			employerDTO.setWebside(employer.getWebside());
			
			
				return employerDTO;
			
		
	}
	//--------------------------
	public List<EmployerDTO> getAllEmployers() {
		
		List<Employer> employers=	employerRepository.findAll();
		
		
		List<EmployerDTO> employerDTOs = new ArrayList<>();
		employers.stream()
            .map(emplyr -> new EmployerDTO( emplyr.getCompanyName()
            		                         , emplyr.getEmail()
            		                         , emplyr.getPassword()
		                                     , emplyr.getPhone()
            		                         , emplyr.getWebside()))
            .forEach(employerDTOs::add);
        
		return employerDTOs;
	}
//-----------------
	public void deleteEmployerById(Long id) {
		
		employerRepository.deleteById(id);
		
	}
	//--------------------
	public void deleteAllEmplloyers() {
		
		employerRepository.deleteAll();
		
	}
	public EmployerRequest updateEmployer(EmployerRequest employerRequest, Long id) {
		Employer employer=getEmployerById(id);
		
	boolean isSame=	employer.getEmail().equals(employerRequest.getEmail());
	
	if (!isSame) {
		
		 throw  new BadRequestException(ErrorMessage.EMAIL_NOT_MUCH);
		
	}
		
		employer.setCompanyName(employerRequest.getCompanyName());
		employer.setEmail(employerRequest.getEmail());
		employer.setPassword(employerRequest.getPassword());
		employer.setPhone(employerRequest.getPhone());
		employer.setWebside(employerRequest.getWebside());
		
		employerRepository.save(employer);
		
		return employerRequest ;
	}


	// -------- METHOD getById
		public Employer  getEmployerById (Long id) {
			
			Employer employer =	employerRepository.findById(id)
	                .orElseThrow(()-> new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)));

			return employer;
			
		}
		
    // -----Method getAll ------
		public List<Employer> getAll(){
			List<Employer> employers=	employerRepository.findAll();
			return employers;
		}

		

		


		


		
	
}
