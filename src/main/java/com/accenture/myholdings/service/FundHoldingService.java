package com.accenture.myholdings.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.myholdings.dao.FundHoldingRepository;
import com.accenture.myholdings.exceptions.MyHoldingsException;
import com.accenture.myholdings.model.FundHoldingId;
import com.accenture.myholdings.model.FundHoldings; 

@Service
public class FundHoldingService {


	@Autowired 
	FundHoldingRepository repository;


	
	public FundHoldings findById( FundHoldingId fhId) {
		
		Optional<FundHoldings> optFundHolding = repository.findById(fhId);
		
		if(optFundHolding.isPresent())
			return optFundHolding.get();
		else
			throw new MyHoldingsException("FundHolding not found");
		
		
	}

	
	public void delete(FundHoldings inv) {
		try {

			repository.delete(inv);
		}catch (Exception e) {

			throw new MyHoldingsException("Error deleting FundHolding");
		}
		
	}


	public void deleteById(FundHoldingId id) {
		
		try {

			repository.delete(findById(id));;
			
		}catch (Exception e) {

			throw new MyHoldingsException("Error deleting FundHolding");
		}
	}
  
	public Iterable<FundHoldings> findAll() {
		try {

			return repository.findAll();
		}catch (Exception e) {

			throw new MyHoldingsException("Error retreiving FundHoldings");
		}
	}
 
 
	public <S extends FundHoldings> S save(S inv) {
		try {

			return repository.save(inv);
			
		}catch (Exception e) {

			throw new MyHoldingsException("Error saving FundHolding");
		}
	}

	 
	
	

}
