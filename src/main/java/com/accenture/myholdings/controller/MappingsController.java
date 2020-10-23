package com.accenture.myholdings.controller;

import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.myholdings.dao.FundHoldingService;
import com.accenture.myholdings.dao.FundService;
import com.accenture.myholdings.dao.HoldingService;
import com.accenture.myholdings.dao.InvestorService;
import com.accenture.myholdings.model.Fund;
import com.accenture.myholdings.model.FundHoldings;
import com.accenture.myholdings.model.Holding;
import com.accenture.myholdings.model.Investor;
import com.accenture.myholdings.model.InvestorFunds;

import lombok.Data;

@RestController
public @Data class MappingsController {

	@Autowired
	InvestorService investorServ;
	
	@Autowired
	FundService fundService;
	
	@Autowired
	HoldingService holdingService;
	
	@Autowired
	FundHoldingService fundHoldingService;
	
	
	
	 
	
	@PostMapping("/addFundToInvestor")
	public Investor addFundToInvestor (@RequestBody InvestorFunds inFu ) {
		Investor inv = investorServ.findById(inFu.getInvestorId()).get() ;
		Fund fund = fundService.findById(inFu.getFundId()).get();
		
		if ( !inv.getFunds().contains(fund) ) {
			inv.getFunds().add(fund);
			return investorServ.save(inv);
		}
		
		return inv;
		
		
	}
	
	@PostMapping("/removeFundFromInvestor")
	public Investor removeFundFromInvestor (@RequestBody InvestorFunds inFu ) {
		
		Investor inv = investorServ.findById(inFu.getInvestorId()).get() ;
		Fund fund = fundService.findById(inFu.getFundId()).get();
		
		
		if(inv.getFunds().remove(fund)) {
			

			return investorServ.save(inv); 
		}

		return  inv; 
		
		
	}
	
	@PostMapping("/addHoldingToFund")
	public Fund addHoldingToFund (@RequestBody FundHoldings fuHo ) {
		
		Fund fund = fundService.findById(fuHo.getFundId()).get();
		Holding holding = holdingService.findById(fuHo.getHoldingsId()).get();
		
		if( holding !=null && !fund.getHoldings().contains(holding) ) {
			fund.getHoldings().add(holding);
			
			
			return fundService.save(fund);
		}
		

		fundHoldingService.save(fuHo);		
		
		return fund;
		
	}
	
	
	@PostMapping("/removeHoldingFromFund")
	public Fund removeHoldingFromFund (@RequestBody FundHoldings fuHo ) {

		Fund fund = fundService.findById(fuHo.getFundId()).get();
		Holding holding = holdingService.findById(fuHo.getFundId()).get();
		
		if(fund.getHoldings().remove(holding)) {

			return fundService.save(fund);
			
		}
		
		return fund;
	}
	
	
	
	
	
	  
	
}
