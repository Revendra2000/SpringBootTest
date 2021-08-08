package com.mycompany.entity;

import java.util.Date;

public class PostJobForm {

//	 jobId : autogenreated(number) PrimaryKey
//	 aadhar_no : String Varchar2(12) (Foreign Key references to users table) // who posted job
//	 category_id : number (Foreign Key references to categories table) //ui dropdown
//	 work_state : String Varchar2(30) //ui dropdown
//	 work_city : String Varchar2(30) [cities only] //ui text
//	 work_pincode : String Varchar2(6)  //ui text
//	 work_area : String Varchar2(50)  //ui text
//	 work_description : String Varchar2(100)  //ui text
//	 isActive : boolean(true/false)
//	 estimated_cost : number(7)  //ui text
//	 date_of_job_post : Date(current date automatically filled)
//	 last_date : Date  //ui text calendar
//	 job_type : String Varchar2(30) (monthly,dailywage)  //ui dropdown
//	 job_assigned_to : String Varchar2(12) (aadhar number of worker FK(users Table))
	
	
	
	 private int categoryId ;
	 private String workState;
	 private String workCity;
	 private String workPincode;
	 private String workArea;
	 private String workDescription;
	 private String estimatedCost;
	 private Date lastDate ;
	 private String jobType ;
	 
	 
	 
	public PostJobForm() {
	}


	public PostJobForm(int categoryId, String workState, String workCity, String workPincode, String workArea,
			String workDescription, String estimatedCost, Date lastDate, String jobType) {
		super();
		this.categoryId = categoryId;
		this.workState = workState;
		this.workCity = workCity;
		this.workPincode = workPincode;
		this.workArea = workArea;
		this.workDescription = workDescription;
		this.estimatedCost = estimatedCost;
		this.lastDate = lastDate;
		this.jobType = jobType;
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
	public String getEstimatedCost() {
		return estimatedCost;
	}
	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
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


	@Override
	public String toString() {
		return "PostJobForm [categoryId=" + categoryId + ", workState=" + workState + ", workCity=" + workCity
				+ ", workPincode=" + workPincode + ", workArea=" + workArea + ", workDescription=" + workDescription
				+ ", estimatedCost=" + estimatedCost + ", lastDate=" + lastDate + ", jobType=" + jobType + "]";
	}  
	 
	 //th:field="*{workCity}"
}
