package com.mycompany.entity;

public class User {
	String fname;
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
