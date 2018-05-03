package com.entity3;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private int empId;
	private String empName;
	
	private Department depat;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Department getDepat() {
		return depat;
	}
	public void setDepat(Department depat) {
		this.depat = depat;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
	
	
	
	

}
