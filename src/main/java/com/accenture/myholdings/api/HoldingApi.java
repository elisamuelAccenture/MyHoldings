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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.accenture.myholdings.exceptions.MyHoldingsException;
import com.accenture.myholdings.model.Holding;
import com.accenture.myholdings.service.HoldingService;

import lombok.Data;

@RestController
public @Data class HoldingApi {

	@Autowired
	HoldingService holdingServ;
	
	
	
	@PostMapping("/holding")
	public ResponseEntity<Holding> create (@RequestBody Holding inv) {
	 
		
		try {
				
			 Holding body = holdingServ.save(inv);
			
			return new ResponseEntity<Holding>(body, HttpStatus.OK);
			
		}catch (MyHoldingsException  ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
		
		
	}
	
	@GetMapping("/holdings")
	public ResponseEntity<Iterable<Holding>> getHoldings() {
 
		Iterable<Holding>  body= holdingServ.findAll();
		return new ResponseEntity<Iterable <Holding>>(body, HttpStatus.OK);
	}
	
	
	@GetMapping("/holding/{id}")
	public ResponseEntity<Holding> getHoldingById(@PathVariable Long id) {
		 
		
		try {

			Holding body = holdingServ.findById(id);
			return new ResponseEntity<Holding>(body, HttpStatus.OK);
			
		}catch (MyHoldingsException ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
		
	}
	
	@PutMapping("/holding")
	public ResponseEntity<Holding> update(@RequestBody Holding inv) {
		
		
		try {

			Holding body = holdingServ.save(inv);
			return new ResponseEntity<Holding>(body, HttpStatus.OK);
			
		}catch (MyHoldingsException ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
		
		
	}
	
	 
	
	
	@DeleteMapping("/holding/{id}")
	public void delete(@PathVariable Long id) {
		
		try {

			holdingServ.deleteById(id);
			
		}catch (MyHoldingsException ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , ex.getMessage());
		}
	}
	
}
