package com.mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.entity.AllPostedJobDetails;
import com.mycompany.entity.AppliedUserDetails;
import com.mycompany.entity.JobDetails;
import com.mycompany.entity.PostJobForm;
import com.mycompany.service.CategoryService;
import com.mycompany.service.PostJobService;

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
	
	
	@Autowired
	private PostJobService postJobService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	@GetMapping("/job_post")
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
		
		//Fetching the categories from database
		//Job Type Dropdown
	
		//Adding data for categories dropdown
		
//		List<String> categoriesList=new ArrayList<>();
//		categoriesList.add("Maid");
//		categoriesList.add("Cook");
//		categoriesList.add("Watchman");
//		categoriesList.add("Carpenter");
//		categoriesList.add("Driver");
//		categoriesList.add("Caretaker");
//		categoriesList.add("Nanny");
//		categoriesList.add("Electrician");
//		categoriesList.add("Plumber");
//		categoriesList.add("Sweeper");
//		categoriesList.add("Gardener");
//		categoriesList.add("Washerman");
//		categoriesList.add("Car Mechanic");
//		categoriesList.add("Bike Mechanic");
//		categoriesList.add("Painter");
//		categoriesList.add("Mason");
//		categoriesList.add("Sanitation Worker");
//		categoriesList.add("Home Tutor");
//		

				
		//categoryService.addCategory(new Category("Maid"));
//		categoryService.addCategory(new Category("Painter"));
//		categoryService.addCategory(new Category("Cook"));
//		categoryService.addCategory(new Category("Carpenter"));
//		categoryService.addCategory(new Category("Electrician"));
		
		//categoryService.addCategory(new Category("Washerman"));
	
		
		m.addAttribute("postJobForm",new PostJobForm());
		
		m.addAttribute("categoriesList",categoryService.getAllCategories());
		m.addAttribute("statesList",categoryService.getAllStates());
		m.addAttribute("jobTypeList",categoryService.getAllJobType());
		
		return "job_post";
	}
	
	@PostMapping("/job_post")
	public String processPostJob(@Valid @ModelAttribute("postJobForm") PostJobForm postJobForm,BindingResult result,Model m,HttpServletRequest request) {
	
		System.out.println("In process Post job");
		System.out.println(postJobForm);
		
		if(result.hasErrors())
		{
			m.addAttribute("categoriesList",categoryService.getAllCategories());
			m.addAttribute("statesList",categoryService.getAllStates());
			m.addAttribute("jobTypeList",categoryService.getAllJobType());
			
			return "job_post";
		}
		
		System.out.println("In process Post job");
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		String userType=(String) session.getAttribute("userType");
//		if(userId==null || userType!="Normal")
//		{
//			System.out.println("User not logged in");
//			return "redirect:/AccessDenined";
//		}
		String aadharNo="123456789123";
		JobDetails jobDetails=postJobService.populateJobEntity(postJobForm, aadharNo);
		
		postJobService.addJobDetails(jobDetails);
		System.out.println(postJobForm);
		//m.addAttribute("JobDetails",jobDetails);
		//service.addJob(new Job());
		//return "show_the_posted_job";
		return "redirect:/posted_job_list";
	}
	
	
	@GetMapping("/posted_job_list")
	public String show_posted_job_list(Model m) {
		System.out.println("in all posted job details controller");
		List<JobDetails> jobDetailsList =postJobService.getAllPostedJobs("123456789123");
		List<AllPostedJobDetails> allPostedJobs=postJobService.processAllPostedJobs(jobDetailsList);
		
		System.out.println("allPostedJobs");
		//StringBuilder sb=new StringBuilder();

		
		m.addAttribute("allPostedJobList",allPostedJobs);
		
		return "posted_job_list";	
	}
	
	@GetMapping("/job_applied_list")
	public String job_applied_list(@RequestParam int jobId,Model m) {
		System.out.println("-------------------------- job applied list "+jobId+"-----------------------------------");
		
		List<AppliedUserDetails> userDetails=postJobService.getDetailsOfAllAppliers(jobId);
		
		
		if(userDetails.isEmpty())
			m.addAttribute("isEmpty","true");
		else 
		{
			System.out.println("Job Id "+jobId+" Assigned to "+postJobService.getSelectedWorkerAadharNo(jobId));
			String assignedTo=postJobService.getSelectedWorkerAadharNo(jobId);
			if(assignedTo==null)
				m.addAttribute("isAssigned", "false");
			else {
				m.addAttribute("isAssigned","true");
			}
			m.addAttribute("assignedTo",assignedTo);
				
			
			m.addAttribute("userDetails",userDetails);
			m.addAttribute("isEmpty","false");
		}
		return "job_applied_list";
	}
	//select_candidate?jobId=1&aadharNo=111122223333
			
	@GetMapping("/select_candidate")
	public String select_candidate(@RequestParam int jobId,@RequestParam String aadharNo,Model m) {
		System.out.println("-------------------------- select candidate "+jobId+" aadharNo "+aadharNo+"-----------------------------------");
		
		
			
		int result=postJobService.assignJobToAadharNo(jobId, aadharNo);
		return "redirect:/job_applied_list?jobId="+jobId ;
	}
}
	

