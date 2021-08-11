package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.entity.AllAppliedJob;



public interface IAllAppliedJobDAO extends CrudRepository<AllAppliedJob, Integer> {
	
	//@Query(value="SELECT * FROM all_applied_job WHERE job_id = ?1", nativeQuery = true)

	// List<AllAppliedJob>findAllById(int jobId);
	
	//@Query("SELECT j FROM all_applied_job j WHERE j.job_id = ?1")
	@Transactional
	@Modifying
	@Query("select a.aadhar_worker from All_AllPLIED_JOB a where a.job_id=?1")
	List<AllAppliedJob> findAllUserAadhar(int jobId);

}


