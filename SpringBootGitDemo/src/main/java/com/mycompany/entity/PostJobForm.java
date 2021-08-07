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
}
