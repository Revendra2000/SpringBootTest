package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.entity.JobDetails;

public interface IPostJobDAO extends CrudRepository<JobDetails,Integer>{

	@Query(value="SELECT * FROM Job_Details WHERE Aadhar_No = ?1 ORDER BY JOB_ID DESC", nativeQuery = true)
	  List<JobDetails> findAllById(String aadharNo);
	
//	@Modifying
//	@Query(value = "UPDATE Users u set EMAIL_VERIFICATION_STATUS =:emailVerificationStatus where u.USER_ID = :userId",
//	           nativeQuery = true)
	@Transactional
	@Modifying
	@Query(value = "UPDATE job_details set job_assigned_to =?1,is_active='F' where job_id = ?2", nativeQuery = true)
		int setJobAssignedToOfJobId(String aadharNo,int jobId);
	
	
	@Query(value="SELECT job_assigned_to FROM Job_Details WHERE job_id = ?1", nativeQuery = true)
	  String findSelectedWorkerAadharNo(int jobId);
	
}
