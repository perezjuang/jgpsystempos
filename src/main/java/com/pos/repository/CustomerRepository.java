package com.pos.repository;

import org.springframework.data.repository.CrudRepository;

import com.pos.models.Customer;

	// This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository
	// CRUD refers Create, Read, Update, Delete
	public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	    //List<Customer> findByName(String name);	    
	    //List<Customer> findByNameContaining(String name);
	  
		
	}	