package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mycompany.entity.JobDetails;

public interface IPostJobDAO extends CrudRepository<JobDetails,Integer>{

	@Query(value="SELECT * FROM Job_Details WHERE Aadhar_No = ?1 ORDER BY JOB_ID DESC", nativeQuery = true)
	  List<JobDetails> findAllById(String aadharNo);
	
}
