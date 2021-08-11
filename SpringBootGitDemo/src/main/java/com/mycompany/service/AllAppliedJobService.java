	package com.mycompany.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dao.IAllAppliedJobDAO;
import com.mycompany.entity.AllAppliedJob;
import com.mycompany.entity.AppliedUserDetails;
import com.mycompany.entity.Users;;

@Service("allAppliedJobService")
public class AllAppliedJobService {

	@Autowired
	private IAllAppliedJobDAO dao;
	
	@Autowired
	private UsersService userService;
	
	public List<String> getAllWhoApplied(int jobId)
	{
		System.out.println("In get all who applied");
		List<String> list= dao.findAllUserAadhar(jobId);
		System.out.println("List"+list);
		//System.out.println(list);
		return list;
	}
	
	public List<AppliedUserDetails> getDetailsOfAppliedUser(List<String> usersAadharNos,String jobId)
	{
		List<AppliedUserDetails> appliedUserDetailsList=new ArrayList<>();
		
		for(String aadhar:usersAadharNos)
		{
			Users user=userService.getUserByAadharNo(aadhar);
			
			AppliedUserDetails aud=new AppliedUserDetails();
			
			aud.setAadharNo(aadhar);
			aud.setAddress(user.getAddress());
			
//			System.out.println(user.getGender());
			
			if(user.getGender().equalsIgnoreCase("M"))
				aud.setGender("Male");
			else
				aud.setGender("Female");
//			System.out.println(aud.getGender());
			aud.setJobId(jobId);
			
			aud.setFullName(user.getFirstName()+" "+user.getLastName());
			aud.setMobileNo(user.getContact());
			
			appliedUserDetailsList.add(aud);
			
		}
		System.out.println("AUD"+appliedUserDetailsList);
		return appliedUserDetailsList;
	}
	
}
