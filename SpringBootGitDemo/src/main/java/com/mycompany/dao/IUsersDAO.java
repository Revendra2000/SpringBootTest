package com.mycompany.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mycompany.entity.Users;


public interface IUsersDAO extends CrudRepository<Users, String> {

	@Query(value="SELECT * FROM users WHERE Aadhar_No = ?", nativeQuery = true)
	  Users findByAadhar(String aadharNo);
}
