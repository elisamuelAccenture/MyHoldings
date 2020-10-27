package com.accenture.myholdings.service;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.myholdings.dao.FundHoldingRepository;
import com.accenture.myholdings.dao.FundRepository;
import com.accenture.myholdings.dao.InvestorFundRepository;
import com.accenture.myholdings.exceptions.MyHoldingsException;
import com.accenture.myholdings.model.Fund; 

@Service
public class FundService {


	@Autowired 
	FundRepository repository;
	
	@Autowired
	FundHoldingRepository fundHoldingRepository;
	
	@Autowired
	InvestorFundRepository invFundRepository;
	
	
	
	public Fund findById(Long id) {
		
		Optional<Fund> optFund = repository.findById(id);
		
		if(optFund.isPresent())
			return optFund.get();
		else
			throw new MyHoldingsException("Fund not found");
		
		
	}

	
	public void delete(Fund fund) {
		try {

			
			Optional<Fund> optFund = repository.findById(fund.getId());
			
			if(optFund.isPresent()) {
				if(optFund.get().getFundHoldings().isEmpty() && optFund.get().getInvestorFunds().isEmpty() ) {
					repository.delete(fund);
				}else {

					throw new MyHoldingsException(optFund.get().getName() + " has Holdings or Investors assigned. Please remove all its relationships.");
				}
				
				
			}
			
			
		}catch (Exception e) {

			throw new MyHoldingsException( "Error deleting Fund object. " + e.getMessage());
		}
		
	}


	public void deleteById(Long id) {
		
		try {

			repository.delete(findById(id));;
			
		}catch (Exception e) {

			throw new MyHoldingsException("Error deleting Fund");
		}
	}
  
	public Iterable<Fund> findAll() {
		try {

			return repository.findAll();
		}catch (Exception e) {

			throw new MyHoldingsException("Error retreiving Funds");
		}
	}
 
 
	public <S extends Fund> S save(S inv) {
		try {

			return repository.save(inv);
		
		}catch(ConstraintViolationException ce ) {

			throw new MyHoldingsException("Please verifythe Fund's name. it should be unique."  );
		
		}catch (Exception e) {

			throw new MyHoldingsException("Error saving Fund " + e.getMessage() );
		}
	}

	 
	
	

}
