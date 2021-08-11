package com.mycompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dao.IUsersDAO;
import com.mycompany.entity.Users;

@Service("usersService")
public class UsersService {

	@Autowired
	private IUsersDAO dao;
	
	Users getUserByAadharNo(String aadharNo)
	{
		return dao.findByAadhar(aadharNo);
	}
	
}
