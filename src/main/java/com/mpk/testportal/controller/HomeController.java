package com.mpk.testportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/home")
	public String showHomePage() {
		
		logger.info("I am at HOME ...");
		
		return "home";
		
	}
	@GetMapping("/")
	public String getHomePage() {
		
		logger.info("I am at HOME ...");
		
		return "home";
		
	}

}
