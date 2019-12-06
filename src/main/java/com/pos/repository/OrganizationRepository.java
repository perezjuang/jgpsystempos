package com.pos.repository;

import org.springframework.data.repository.CrudRepository;

import com.pos.models.Organization;

	// This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository
	// CRUD refers Create, Read, Update, Delete
	public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
	
	    //List<Customer> findByName(String name);	    
	    //List<Customer> findByNameContaining(String name);
	  
		
	}	