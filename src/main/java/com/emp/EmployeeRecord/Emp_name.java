package com.emp.EmployeeRecord;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OrderBy;

@Embeddable
public class Emp_name {
	@Column(name="Firstname")
	@OrderBy("Firstname")
 private String fname;
	@Column(name="middlename")
 private String m_name;
	@Column(name="surename")
 private String lname;
	
	public Emp_name() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Emp_name(String fname, String m_name, String lname) {
		super();
		this.fname = fname;
		this.m_name = m_name;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Emp_name [fname=" + fname + ", m_name=" + m_name + ", lname=" + lname + "]";
	}
	
}
