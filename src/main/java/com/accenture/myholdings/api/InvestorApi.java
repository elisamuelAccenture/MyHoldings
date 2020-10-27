package com.accenture.myholdings.api;

import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.myholdings.model.Investor;
import com.accenture.myholdings.service.InvestorService;

import lombok.Data;

@RestController
public @Data class InvestorApi {

	@Autowired
	InvestorService investorServ;
	
	@PostMapping("/investor")
	public Investor create (@RequestBody Investor inv) {
		return investorServ.save(inv);
	}
	
	 
	@GetMapping("/investors")
	public Iterable <Investor> getInvestors() {
		
		return investorServ.findAll();
		
	}
	
	
	
	@GetMapping("/investor/{id}")
	public Optional<Investor> getInvestorById(@PathVariable Long id) {
		
		return investorServ.findById(id);
		
	}
	
	@PutMapping("/investor")
	public Investor update(@RequestBody Investor inv) {
		
		return investorServ.save(inv);
		
	}
	
	@PatchMapping("/investor")
	public Investor patch(@RequestBody Investor inv ) {
		
		Optional<Investor> invExisting = investorServ.findById( inv.getId() );
		
		if(invExisting.isPresent() ) {
			if(inv.getName() ==null   ) {
				inv.setName(invExisting.get().getName());
			}
			
//			inv.getFunds().retainAll(inv.getFunds());
			
			return investorServ.save(inv);
		}
		
		return null;
	}
	
	
	@DeleteMapping("/investor/{id}")
	public void delete(@PathVariable Long id) {
		
		investorServ.deleteById(id);
	}
	
}
