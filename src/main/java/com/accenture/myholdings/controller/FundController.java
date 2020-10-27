package com.accenture.myholdings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.accenture.myholdings.model.Fund;
import com.accenture.myholdings.model.FundHoldings;
import com.accenture.myholdings.service.FundHoldingService;
import com.accenture.myholdings.service.FundService;

@Controller
public class FundController {
 
	@Autowired
	FundService fundService;
	
	@Autowired
	FundHoldingService fundHoldingService;
	

	@GetMapping("/web/fund")
	public String retriveFund( Model model) {
		 
		model.addAttribute("fund", new Fund() );
		Iterable<Fund> fundList = fundService.findAll();
		model.addAttribute("fundList", fundList);
		return "Fund";
	}
	
	@PostMapping("/web/fund")
	public String saveFund(@ModelAttribute Fund obj,  Model model) {
		
		if(obj != null ) {
			fundService.save(obj);
			model.addAttribute("fund", obj);
		}
		
		Iterable<Fund> fundList = fundService.findAll();
		model.addAttribute("fundList", fundList);
		
		
		return "Fund";
	}
	
	
	@GetMapping("/web/removeFund")
	public String removeFund( Model model) {
		 
		model.addAttribute("fund", new Fund() );
		Iterable<Fund> fundList = fundService.findAll();
		model.addAttribute("fundList", fundList);
		return "FundDelete";
	}
	
	@PostMapping("/web/removeFund")
	public String removeFund(@ModelAttribute Fund obj,  Model model) {
		
		if(obj != null ) {
			fundService.delete(obj);
			model.addAttribute("fund", obj);
		}
		
		Iterable<Fund> fundList = fundService.findAll();
		model.addAttribute("fundList", fundList);
		
		
		return "FundDelete";
	}
	

	
	
	@GetMapping("/web/fundHolding")
	public String savefundHolding( Model model) {
		 
		model.addAttribute("fundHolding", new FundHoldings() );
		addFundHoldingList(model);
		return "FundHolding";
	}
	
	@PostMapping("/web/fundHolding")
	public String savefundHolding(@ModelAttribute FundHoldings fundHolding,  Model model) {
		
		if(fundHolding != null ) {
			fundHoldingService.save(fundHolding);
			model.addAttribute("fundHolding", fundHolding);
		}
		
		addFundHoldingList(model);
		
		return "FundHolding";
	}
	
	private void addFundHoldingList(Model model) {

		Iterable<FundHoldings> fundHoldingList = fundHoldingService.findAll();
		model.addAttribute("fundHoldingList", fundHoldingList);
	}
	
	

	@GetMapping("/web/deleteFundHolding")
	public String deleteFundHolding( Model model) {
		 
		model.addAttribute("fundHolding", new FundHoldings() );
		addFundHoldingList(model);
		return "FundHoldingDelete";
	}
	
	@PostMapping("/web/deleteFundHolding")
	public String deleteFundHolding(@ModelAttribute FundHoldings fundHolding,  Model model) {
		
		if(fundHolding != null ) {
			fundHoldingService.delete(fundHolding);
			model.addAttribute("fundHolding", fundHolding);
		}
		
		addFundHoldingList(model);
		
		return "FundHoldingDelete";
	}
	
	
	
	
}
