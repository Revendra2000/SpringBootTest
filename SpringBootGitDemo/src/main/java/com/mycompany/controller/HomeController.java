package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value="/homepage",method=RequestMethod.GET)
	public String homepage() {
		return "homepage";
	}
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String dashboard() {
		return "dashboard";
	}
	


	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String profile() {
		return "profile";
	}
	
	@RequestMapping(value="/all_applied_jobs",method=RequestMethod.GET)
	public String all_applied_jobs() {
		return "all_applied_jobs";
	}
	

	@RequestMapping(value="/Apply_job",method=RequestMethod.GET)
	public String Apply_job() {
		return "Apply_job";
	}	
}
