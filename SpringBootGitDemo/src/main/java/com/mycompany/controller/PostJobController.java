package com.mycompany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.entity.PostJobForm;

@Controller
public class PostJobController {
	
//	@GetMapping("/postJob")
//	public String home(@ModelAttribute  String aadharNo,Model m,HttpServletRequest request) {
//
//		//one way to check logged in user
//		//		if(aadharNo==null)
////		{
////			return "redirect:/AccessDenined";
//////			RedirectView rv=new RedirectView();
//////			rv.setUrl("/AccessDenied");
//////			return rv;
////		}
////		m.addAttribute("AadharNo", aadharNo);
//		
//		
//		//checking logged in user using httpsession
//		
//		HttpSession session=request.getSession();
//		if(session.getAttribute(aadharNo)==null)
//		{
//			System.out.println("User not logged in");
//			return "redirect:/AccessDenined";
//		}
//		m.addAttribute("user",new PostJobForm());
//		return "postJob";
//	}
//	
//	@PostMapping("/register")
//	public String postJob(@ModelAttribute PostJobForm pjf,Model m)
//	{
//		m.addAttribute("user",pjf);
//		return "success";
//	}
	
	
	
	@GetMapping("/postJob")
	public String showPostJob(Model m,HttpServletRequest request) {
	
		System.out.println("In show post job");
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		String userType=(String) session.getAttribute("userType");
//		if(userId==null || userType!="Normal")
//		{
//			System.out.println("User not logged in");
//			return "redirect:/AccessDenined";
//		}
		//Adding data for categories dropdown
		
		List<String> categoriesList=new ArrayList<>();
		categoriesList.add("Maid");
		categoriesList.add("Cook");
		categoriesList.add("Watchman");
		categoriesList.add("Carpenter");
		categoriesList.add("Driver");
		categoriesList.add("Caretaker");
		categoriesList.add("Nanny");
		categoriesList.add("Electrician");
		categoriesList.add("Plumber");
		categoriesList.add("Sweeper");
		categoriesList.add("Gardener");
		categoriesList.add("Washerman");
		categoriesList.add("Car Mechanic");
		categoriesList.add("Bike Mechanic");
		categoriesList.add("Painter");
		categoriesList.add("Mason");
		categoriesList.add("Sanitation Worker");
		categoriesList.add("Home Tutor");
		
		
		List<String> statesList=new ArrayList<>();
		statesList.add("Andhra Pradesh");
		statesList.add("Arunachal Pradesh");
		statesList.add("Assam");
		statesList.add("Bihar");
		statesList.add("Chhattisgarh");
		statesList.add("Goa");
		statesList.add("Gujarat");
		statesList.add("Haryana");
		statesList.add("Himachal Pradesh");
		statesList.add("Jammu and Kashmir");
		statesList.add("Jharkhand");
		statesList.add("Karnataka");
		statesList.add("Kerala");
		statesList.add("Madhya Pradesh");
		statesList.add("Maharashtra");
		statesList.add("Manipur");
		statesList.add("Meghalaya");
		statesList.add("Mizoram");
		statesList.add("Nagaland");
		statesList.add("Odisha");
		statesList.add("Pumjab");
		statesList.add("Rajasthan");
		statesList.add("Sikkim");
		statesList.add("Tamil Nadu");
		statesList.add("Telangana");
		statesList.add("Tripura");
		statesList.add("Uttar Pradesh");
		statesList.add("Uttarakhand");
		statesList.add("West Bengal");
		
		
		
		
		m.addAttribute("user",new PostJobForm());
		m.addAttribute("categoriesList",categoriesList);
		m.addAttribute("statesList",statesList);
		
		return "job_post";
	}
	
	@PostMapping("/postJob")
	public String processPostJob(@ModelAttribute PostJobForm postJobForm,Model m,HttpServletRequest request) {
	
		System.out.println("In process Post job");
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		String userType=(String) session.getAttribute("userType");
//		if(userId==null || userType!="Normal")
//		{
//			System.out.println("User not logged in");
//			return "redirect:/AccessDenined";
//		}
		//m.addAttribute("PostJobForm",new PostJobForm());
		System.err.println(m.getAttribute("PostJobForm"));
		return "redirect:/successfull";
	}
}
