package com.mycompany.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "JOB_DETAILS")
public class JobDetails{
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "job_id_Sequence")
    @SequenceGenerator(name = "job_id_Sequence", sequenceName = "JOB_ID_SEQ", allocationSize = 1)
	@Column(name="JOB_ID")
	private int jobId;
	
	@Column(name="AADHAR_NO", length=12)
	private String aadharNo;
	
	@Column(name="CATEGORY_ID", length=30)
	private int categoryId;
	
	@Column(name="WORK_STATE", length=30, nullable=false)
	private String  workState;
	
	@Column(name="WORK_CITY", length=30, nullable=false)
	private String workCity;
	
	@Column(name="WORK_PINCODE", length=6, nullable=false)
	private String workPincode;
	
	@Column(name="WORK_AREA", length=50, nullable=false)
	private String workArea;
	
	@Column(name="WORK_DESCRIPTION",length=1000, nullable=false)
	private String workDescription;
	
	@Column(name="IS_ACTIVE",length=1, nullable=false)
	private String isActive;
	
	@Column(name="ESTIMATED_COST", nullable=false)
	private int estimatedCost;
	
	@Column(name="DATE_OF_POST",nullable=false)
	private Date dateOfPost;
	
	@Column(name="LAST_DATE",nullable=false)
	private Date lastDate;
	
	@Column(name="JOB_TYPE",length=30,nullable=false)
	private String jobType;
	
	@Column(name="JOB_ASSIGNED_TO",length=12)
	private String jobAssignedTo;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkPincode() {
		return workPincode;
	}

	public void setWorkPincode(String workPincode) {
		this.workPincode = workPincode;
	}

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(int estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public Date getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobAssignedTo() {
		return jobAssignedTo;
	}

	public void setJobAssignedTo(String jobAssignedTo) {
		this.jobAssignedTo = jobAssignedTo;
	}

	@Override
	public String toString() {
		return "JobDetails [jobId=" + jobId + ", aadharNo=" + aadharNo + ", categoryId=" + categoryId + ", workState="
				+ workState + ", workCity=" + workCity + ", workPincode=" + workPincode + ", workArea=" + workArea
				+ ", workDescription=" + workDescription + ", isActive=" + isActive + ", estimatedCost=" + estimatedCost
				+ ", dateOfPost=" + dateOfPost + ", lastDate=" + lastDate + ", jobType=" + jobType + ", jobAssignedTo="
				+ jobAssignedTo + "]";
	}
	
	
	
	
}
