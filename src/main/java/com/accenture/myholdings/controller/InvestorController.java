package com.accenture.myholdings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.accenture.myholdings.dao.InvestorFundRepository;
import com.accenture.myholdings.model.Investor;
import com.accenture.myholdings.model.InvestorFunds;
import com.accenture.myholdings.service.InvestorService;

@Controller
public class InvestorController {

	@Autowired
	InvestorService investorServ;
		
	@Autowired
	InvestorFundRepository investorFundRepository;

	
	@GetMapping("/web/investor")
	public String retriveInvestor( Model model) {
		 
		model.addAttribute("investor", new Investor() );
		addInvestorList(model);
		return "Investor";
	}
	
	@PostMapping("/web/investor")
	public String saveInvestor(@ModelAttribute Investor investor,  Model model) {
		
		if(investor != null ) {
			investorServ.save(investor);
			model.addAttribute("investor", investor);
		}
		
		addInvestorList(model);
		
		return "Investor";
	}
	
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
		
		addInvestorFundList(model);
		
		return "InvestorFund";
	}
	
	private void addInvestorFundList(Model model) {

		Iterable<InvestorFunds> investorFundList = investorFundRepository.findAll();
		model.addAttribute("investorFundList", investorFundList);
	}
	
	
	@GetMapping("/web/deleteInvestorFund")
	public String deleteInvestorFund( Model model) {
		 
		model.addAttribute("investorFund", new InvestorFunds() );
		addInvestorFundList(model);
		return "InvestorFundDelete";
	}
	
	@PostMapping("/web/deleteInvestorFund")
	public String deleteInvestorFund(@ModelAttribute InvestorFunds investorFund,  Model model) {
		
		if(investorFund != null ) {
			investorFundRepository.delete(investorFund);
			model.addAttribute("investorFund", investorFund);
		}
		
		addInvestorFundList(model);
		
		return "InvestorFundDelete";
	}
	 
	
	
	
}
