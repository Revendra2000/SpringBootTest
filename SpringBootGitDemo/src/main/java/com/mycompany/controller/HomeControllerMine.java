package com.mycompany.controller;
//swagger-ui.html
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.entity.User;

@Controller
public class HomeControllerMine {

	@GetMapping(value={"/","/home"})
	public String home(Model m) {
		
		
		return "home1";
	}
	
	@PostMapping("/showUser")
	public String showUser(Model m,HttpServletRequest  request) {
		//m.addAttribute("Fname","Just");
		//m.addAttribute("id",1);
		System.out.println("In show user");
//		m.addAttribute("session", (String)request.getAttribute("Firstname"));
//		System.out.println("Request "+(String)request.getSession().getAttribute("Lastname"));
//		System.out.println("Request "+(String)request.getAttribute("Firstname"));
		return "showUser";
	}
	
	@GetMapping("/register")
	public String showRegisterUserForm(User user)
	{
		System.out.println("In show Register Form");
//		m.addAttribute("user",new User());
		return "register";
	}
	
//	@PostMapping("/register")
//	public String registerUser(@Valid @ModelAttribute("user") User u,Model m,HttpServletRequest request,BindingResult result)
//	{
//		System.out.println("In register user");
//		System.out.println("BindingResult.hasError"+result.hasErrors());
//		if(result.hasErrors())
//			return "register";
//		
//		HttpSession session=request.getSession();
//		session.setAttribute("Firstname", u.getFname());
//		session.setAttribute("Lastname", u.getLname());
//		System.out.println("Session "+session.getAttribute("Firstname")+" "+session.getAttribute("Lastname"));
////		System.out.println(u.getFname()+" "+u.getLname());
//		m.addAttribute("user",u);
//		return "forward:/showUser";
//	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute User u,Model m,BindingResult result)
	{
		System.out.println("In register user");
		//System.out.println("BindingResult.hasError"+result.hasErrors());
		if(result.hasErrors())
			return "register";
		
		System.out.println(u.getFname()+" "+u.getLname());
		m.addAttribute("user",u);
//		return "forward:/showUser";
		System.err.println("success");
		return "register";
	}
}
