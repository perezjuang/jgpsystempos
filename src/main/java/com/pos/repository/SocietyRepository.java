package com.pos.repository;

import org.springframework.data.repository.CrudRepository;

import com.pos.models.Society;

	// This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository
	// CRUD refers Create, Read, Update, Delete
	public interface SocietyRepository extends CrudRepository<Society, Integer> {
	
	    //List<Customer> findByName(String name);	    
	    //List<Customer> findByNameContaining(String name);
	  
		
	}	