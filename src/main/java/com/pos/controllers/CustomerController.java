package com.pos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pos.models.Customer;
import com.pos.repository.CustomerRepository;

@Controller   
//@ComponentScan(basePackages = "com.pos")
@RequestMapping(path="/Customer") 
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping(path="/createncustomer") 
	public @ResponseBody ResponseEntity<String> createCustomer (
			@RequestBody Customer customer) {		
		customerRepository.save(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping(path="/updatecustomer") 
	public @ResponseBody ResponseEntity<String> createNewCustomer (
			@RequestBody Customer customer) {		
		customerRepository.save(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(path="/getallcustomer")
	public @ResponseBody Iterable<Customer> getAllCustomer() {
		// This returns a JSON or XML with the users
		return customerRepository.findAll();		
	}	
	
	@PostMapping(path="/removecustomer") 
	public @ResponseBody ResponseEntity<String> removeCustomer (
			@RequestBody Customer customer) {
		customerRepository.delete(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
		
}