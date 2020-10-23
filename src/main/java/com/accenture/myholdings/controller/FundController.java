package com.accenture.myholdings.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.accenture.myholdings.dao.FundService; 
import com.accenture.myholdings.model.Fund; 

@RestController
public class FundController {

	@Autowired
	FundService fundServ;
		
	@PostMapping("/fund")
	public ResponseEntity<Fund> create (@RequestBody Fund fund) {
		
		try {

			Fund body = fundServ.save(fund);
			
			return new ResponseEntity<Fund>(body, HttpStatus.OK);
			
		}catch (Exception ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
		
	}
	
	@GetMapping("/funds")
	public ResponseEntity<Iterable <Fund>> getfunds() {

		Iterable<Fund>  body= fundServ.findAll();
		return new ResponseEntity<Iterable <Fund>>(body, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/fund/{id}")
	public Optional<Fund> getFundById(@PathVariable Long id) {
		
		return fundServ.findById(id);
		
	}
	
	@PutMapping("/fund")
	public Fund update(@RequestBody Fund fund) {
		
		return fundServ.save(fund);
		
	}
	
	
	@DeleteMapping("/fund/{id}")
	public void delete(@PathVariable Long id) {
		
		fundServ.deleteById(id);
	}
	
}
