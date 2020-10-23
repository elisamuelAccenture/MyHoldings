package com.accenture.myholdings.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.myholdings.dao.HoldingService;
import com.accenture.myholdings.model.Holding; 

import lombok.Data;

@RestController
public @Data class HoldingController {

	@Autowired
	HoldingService holdingServ;
	
	
	
	@PostMapping("/holding")
	public Holding create (@RequestBody Holding inv) {
		return holdingServ.save(inv);
	}
	
	@GetMapping("/holdings")
	public Iterable <Holding> getHoldings() {
		
		return holdingServ.findAll();
		
	}
	
	
	@GetMapping("/holding/{id}")
	public Optional<Holding> getHoldingById(@PathVariable Long id) {
		
		return holdingServ.findById(id);
		
	}
	
	@PutMapping("/holding")
	public Holding update(@RequestBody Holding inv) {
		
		return holdingServ.save(inv);
		
	}
	
	 
	
	
	@DeleteMapping("/holding/{id}")
	public void delete(@PathVariable Long id) {
		
		holdingServ.deleteById(id);
	}
	
}
