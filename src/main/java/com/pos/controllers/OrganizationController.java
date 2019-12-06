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

import com.pos.models.Organization;
import com.pos.repository.OrganizationRepository;

@Controller   
//@ComponentScan(basePackages = "com.pos")
@RequestMapping(path="/Organization") 
public class OrganizationController {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@PostMapping(path="/createnorganization") 
	public @ResponseBody ResponseEntity<String> createOrganization (
			@RequestBody Organization organization) {		
		organizationRepository.save(organization);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping(path="/updateorganization") 
	public @ResponseBody ResponseEntity<String> createNewOrganization (
			@RequestBody Organization organization) {		
		organizationRepository.save(organization);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(path="/getallorganization")
	public @ResponseBody Iterable<Organization> getAllOrganization() {
		// This returns a JSON or XML with the users
		return organizationRepository.findAll();		
	}	
	
	@PostMapping(path="/removeorganization") 
	public @ResponseBody ResponseEntity<String> removeOrganization (
			@RequestBody Organization organization) {
		organizationRepository.delete(organization);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
		
}