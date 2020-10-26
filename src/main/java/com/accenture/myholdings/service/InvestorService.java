package com.accenture.myholdings.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.myholdings.dao.InvestorRepository;
import com.accenture.myholdings.exceptions.MyHoldingsException;
import com.accenture.myholdings.model.Investor;

@Service
public class InvestorService {


	@Autowired 
	InvestorRepository invRepo;
	
	public Optional<Investor> findById(Long id) {
		
		Optional<Investor> optInvestor = invRepo.findById(id);
		
		if(optInvestor.isPresent())
			return optInvestor;
		else
			throw new MyHoldingsException("Investor not found");
		
		
	}

	
	public void delete(Investor inv) {
		try {

			invRepo.delete(inv);
		}catch (Exception e) {

			throw new MyHoldingsException("Error deleting Investor");
		}
		
	}


	public void deleteById(Long id) {
		
		try {

			invRepo.deleteById(id);;
			
		}catch (Exception e) {

			throw new MyHoldingsException("Error deleting Investor");
		}
	}
  
	public Iterable<Investor> findAll() {
		try {

			return invRepo.findAll();
		}catch (Exception e) {

			throw new MyHoldingsException("Error retreiving Investors");
		}
	}
 
 
	public <S extends Investor> S save(S inv) {
		try {

			return invRepo.save(inv);
			
		}catch (Exception e) {

			throw new MyHoldingsException("Error saving Investor");
		}
	}

	 
	
	

}
