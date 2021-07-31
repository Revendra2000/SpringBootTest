package com.mycompany.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	//temp1 branch
	@GetMapping("/home/profile")
	public String profile() {
		return "profile.jsp";
	}
	
}
