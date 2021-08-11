package com.mycompany.entity;

import javax.validation.constraints.NotBlank;

public class User {
	
	@NotBlank(message = "Please provide fname")
	String fname;
	@NotBlank(message = "Please provide lname")
	String lname;
	
	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + "]";
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
