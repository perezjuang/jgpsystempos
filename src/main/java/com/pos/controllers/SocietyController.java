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

import com.pos.models.Society;
import com.pos.repository.SocietyRepository;

@Controller   
//@ComponentScan(basePackages = "com.pos")
@RequestMapping(path="/Society") 
public class SocietyController {
	
	@Autowired
	private SocietyRepository societyRepository;
	
	@PostMapping(path="/creatensociety") 
	public @ResponseBody ResponseEntity<String> createSociety (
			@RequestBody Society society) {		
		societyRepository.save(society);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping(path="/updatesociety") 
	public @ResponseBody ResponseEntity<String> createNewSociety (
			@RequestBody Society society) {		
		societyRepository.save(society);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(path="/getallsociety")
	public @ResponseBody Iterable<Society> getAllSociety() {
		// This returns a JSON or XML with the users
		return societyRepository.findAll();		
	}	
	
	@PostMapping(path="/removesociety") 
	public @ResponseBody ResponseEntity<String> removeSociety (
			@RequestBody Society society) {
		societyRepository.delete(society);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
		
}