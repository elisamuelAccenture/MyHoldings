package com.accenture.myholdings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.accenture.myholdings.dao.InvestorFundRepository;
import com.accenture.myholdings.model.Fund;
import com.accenture.myholdings.model.Investor;
import com.accenture.myholdings.model.InvestorFunds;
import com.accenture.myholdings.service.InvestorService;

@Controller
public class InvestorController {

	@Autowired
	InvestorService investorServ;
		
	@Autowired
	InvestorFundRepository investorFundRepository;

	
	@GetMapping("web/investor")
	public String retriveInvestor( Model model) {
		 
		model.addAttribute("investor", new Investor() );
		addInvestorList(model);
		return "Investor";
	}
	
	@PostMapping("/web/investor")
	public String saveInvestor(@ModelAttribute Investor investor,  Model model) {
		
		if(investor != null ) {
			investorServ.save(investor);
			model.addAttribute("investor", new Investor() );
		}
		
		addInvestorList(model);
		
		return "Investor";
	}
	//***********************************************************
	 
	@GetMapping(value= {"/web/removeInvestor","/web/removeInvestor/{id}"})
	public String removeInvestor( @PathVariable( required = false ) Long id , Model model) {
		 
		if(id !=null)
			model.addAttribute("investor", new Investor(id) );
		else
			model.addAttribute("investor", new Investor() );
		
		addInvestorList(model);
		return "InvestorDelete";
	}
	
	@PostMapping("/web/removeInvestor")
	public String removeInvestor(@ModelAttribute Investor investor,  Model model) {
		
		if(investor != null ) {
			investorServ.delete(investor); 

			model.addAttribute("investor", new Investor() );
		}
		
		addInvestorList(model);
		
		return "InvestorDelete";
	}
	

	//***********************************************************
	
	
	private void addInvestorList(Model model) {

		Iterable<Investor> investorList = investorServ.findAll();
		model.addAttribute("investorList", investorList);
	}
	
	
	
	@GetMapping("/web/investorFund")
	public String saveInvestorFund( Model model) {
		 
		model.addAttribute("investorFund", new InvestorFunds() );
		addInvestorFundList(model);
		return "InvestorFund";
	}
	
	@PostMapping("/web/investorFund")
	public String saveInvestorFund(@ModelAttribute InvestorFunds investorFund,  Model model) {
		
		if(investorFund != null ) {
			investorFundRepository.save(investorFund);
			model.addAttribute("investorFund", investorFund);
		}

		model.addAttribute("investorFund", new InvestorFunds() );
		addInvestorFundList(model);
		
		return "InvestorFund";
	}
	
	private void addInvestorFundList(Model model) {

		Iterable<InvestorFunds> investorFundList = investorFundRepository.findAll();
		model.addAttribute("investorFundList", investorFundList);
	}
	
	 
	@GetMapping(value= {"/web/deleteInvestorFund","/web/deleteInvestorFund/{investorId}/{fundId}"})
	public String deleteInvestorFund(
			@PathVariable(name= "investorId", required = false ) Long investorId,
			@PathVariable( name = "fundId", required = false ) Long fundId,  Model model) {
		 
		if(investorId!=null && fundId!=null)
			model.addAttribute("investorFund", new InvestorFunds(investorId, new Fund(fundId)) );
		else
			model.addAttribute("investorFund", new InvestorFunds() );
		
		addInvestorFundList(model);
		return "InvestorFundDelete";
	}
	
	@PostMapping("/web/deleteInvestorFund")
	public String deleteInvestorFund(@ModelAttribute InvestorFunds investorFund,  Model model) {
		
		if(investorFund != null ) {
			investorFundRepository.delete(investorFund); 
		}
		model.addAttribute("investorFund", new InvestorFunds() );
		
		addInvestorFundList(model);
		
		return "InvestorFundDelete";
	}
	 
	
	
	
}
