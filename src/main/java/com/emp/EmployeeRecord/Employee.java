package com.emp.EmployeeRecord;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity


@Table(name="Employeerecord")
public class Employee {
	

	@Id
	@GeneratedValue(generator="CUST_SEQ")
	private int id;
	
	@Embedded
	 Emp_name name;
	@Column(name="salary",length=7)

	private double sal;
	@Transient
	private String img;
	@Temporal(TemporalType.DATE)
	private Date joindate;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, Emp_name name, double sal, String img, Date joindate) {
		super();
		this.id = id;
		//this.name = name;
		this.sal = sal;
		this.img = img;
		this.joindate = joindate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Emp_name getName() {
		return name;
	}
	public void setName(Emp_name name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", joindate=" + joindate + "]";
	}
	
	
	
}
