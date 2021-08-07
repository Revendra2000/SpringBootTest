package com.mycompany.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.mycompany.entity.PostJobForm;
import com.mycompany.entity.User;

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
	
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		String userType=(String) session.getAttribute("userType");
		if(userId==null || userType!="Normal")
		{
			System.out.println("User not logged in");
			return "redirect:/AccessDenined";
		}
		m.addAttribute("user",new PostJobForm());
		return "postJob";
	}
	
	@PostMapping("/postJob")
	public String processPostJob(@ModelAttribute PostJobForm postJobForm,Model m,HttpServletRequest request) {
	
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		String userType=(String) session.getAttribute("userType");
		if(userId==null || userType!="Normal")
		{
			System.out.println("User not logged in");
			return "redirect:/AccessDenined";
		}
		m.addAttribute("user",new PostJobForm());
		return "postJob";
	}
}
