package com.accenture.myholdings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.accenture.myholdings.model.Holding;
import com.accenture.myholdings.model.Investor;
import com.accenture.myholdings.service.HoldingService; 

@Controller
public class HoldingController {
 
	@Autowired
	HoldingService holdingServ;
	
 
	@GetMapping("/web/holding")
	public String retriveHolding( Model model) {
		 
		model.addAttribute("holding", new Holding() );
		
		addListToModel(model);
		
		return "Holding";
	}
	
	@PostMapping("/web/holding")
	public String saveHolding(@ModelAttribute Holding obj,  Model model) {
		
		if(obj != null ) {
			holdingServ.save(obj);
			model.addAttribute("holding", obj);
		}

		addListToModel(model);
		return "Holding";
	}
	
	
	private void addListToModel(Model model) {
		Iterable<Holding> holdingList = holdingServ.findAll();
		model.addAttribute("holdingList", holdingList);
	}
	
	
	//******************************************
	


	@GetMapping(value= {"/web/removeHolding","/web/removeHolding/{id}"})
	public String removeHolding( @PathVariable( required = false ) Long id , Model model) {

		if(id !=null)
			model.addAttribute("holding", new Holding(id) );
		else
			model.addAttribute("holding", new Holding() );
		
		addListToModel(model);
		
		return "HoldingDelete";
	}
	
	@PostMapping("/web/removeHolding")
	public String removeHolding(@ModelAttribute Holding obj,  Model model) {
		
		if(obj != null ) {
			holdingServ.delete(obj);
			model.addAttribute("holding", obj);
		}

		addListToModel(model);
		return "HoldingDelete";
	}
}
