package com.accenture.myholdings.api;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.accenture.myholdings.exceptions.MyHoldingsException;
import com.accenture.myholdings.model.Fund;
import com.accenture.myholdings.service.FundService; 

@RestController
@RequestMapping("/api")
public class FundApi {

	@Autowired
	FundService fundServ;
		
	@PostMapping("/fund")
	public ResponseEntity<Fund> create (@RequestBody Fund fund) {
		
		try {
 				
			Fund body = fundServ.save(fund);
			
			return new ResponseEntity<Fund>(body, HttpStatus.OK);
			
		}catch (MyHoldingsException  ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
		
	}
	
	@GetMapping("/funds")
	public ResponseEntity<Iterable <Fund>> getfunds() {

		Iterable<Fund>  body= fundServ.findAll();
		return new ResponseEntity<Iterable <Fund>>(body, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/fund/{id}")
	public ResponseEntity<Fund>  getFundById(@PathVariable Long id) {
		
		
		try {

			Fund body = fundServ.findById(id);
			return new ResponseEntity<Fund>(body, HttpStatus.OK);
			
		}catch (Exception ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
		
	}
	
	@PutMapping("/fund")
	public ResponseEntity<Fund> update(@RequestBody Fund fund) {
		 
		try {

			Fund body = fundServ.save(fund);
			return new ResponseEntity<Fund>(body, HttpStatus.OK);
			
		}catch (Exception ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
		
	}
	
	
	@DeleteMapping("/fund/{id}")
	public void delete(@PathVariable Long id) {
		
		
		
		try {

			Fund fund = fundServ.findById(id);
			
			fundServ.delete(fund);
			
		}catch (Exception ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
	}
	
}
