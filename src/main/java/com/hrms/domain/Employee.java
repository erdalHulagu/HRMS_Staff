package com.hrms.domain;

	import java.util.List;
import java.util.Set;
	
	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
	import jakarta.validation.constraints.Email;
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
	 @NoArgsConstructor
	 @Table(name = "tb_emloyee")
	 public class Employee {
	 	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.AUTO)
	 	private Long id;
	 	
	 	
	 
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 }
