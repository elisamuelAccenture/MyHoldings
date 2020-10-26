package com.accenture.myholdings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.accenture.myholdings.model.Fund;
import com.accenture.myholdings.service.FundService;

@Controller
public class FundController {
 
	@Autowired
	FundService fundService;

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
		return "RemoveFund";
	}
	
	@PostMapping("/web/removeFund")
	public String removeFund(@ModelAttribute Fund obj,  Model model) {
		
		if(obj != null ) {
			fundService.delete(obj);
			model.addAttribute("fund", obj);
		}
		
		Iterable<Fund> fundList = fundService.findAll();
		model.addAttribute("fundList", fundList);
		
		
		return "RemoveFund";
	}
	

	
}
