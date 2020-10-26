package com.accenture.myholdings.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.myholdings.dao.HoldingRepository;
import com.accenture.myholdings.exceptions.MyHoldingsException;
import com.accenture.myholdings.model.Holding;

@Service
public class HoldingService {


	@Autowired 
	HoldingRepository repository;
	
	public Holding findById(Long id) {
		
		Optional<Holding> optHolding = repository.findById(id);
		
		if(optHolding.isPresent())
			return optHolding.get();
		else
			throw new MyHoldingsException("Holding not found");
		
		
	}

	
	public void delete(Holding inv) {
		try {

			repository.delete(inv);
		}catch (Exception e) {

			throw new MyHoldingsException("Error deleting Holding");
		}
		
	}


	public void deleteById(Long id) {
		
		try {

			repository.delete(findById(id));;
			
		}catch (Exception e) {

			throw new MyHoldingsException("Error deleting Holding");
		}
	}
  
	public Iterable<Holding> findAll() {
		try {

			return repository.findAll();
		}catch (Exception e) {

			throw new MyHoldingsException("Error retreiving Holdings");
		}
	}
 
 
	public <S extends Holding> S save(S inv) {
		try {

			return repository.save(inv);
			
		}catch (Exception e) {

			throw new MyHoldingsException("Error saving Holding. " + e.getMessage());
		}
	}

	 
	
	

}
