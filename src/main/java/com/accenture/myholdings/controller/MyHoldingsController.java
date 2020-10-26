package com.accenture.myholdings.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 
 
@Controller
public class MyHoldingsController {
 
	
	@GetMapping("/web/menu")
	public String menu( Model model) {
		  
		return "menu";
	}
	
	
	 
	
}
