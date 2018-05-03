package com.entity3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable {
	
	/**
	 * 
	 */
	private int depId;
	private String depName;
	
	/**
	 * Ò»¶Ô¶à
	 */
	private Set<Employee> empSet = new HashSet<Employee>();
	
	
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Set<Employee> getEmpSet() {
		return empSet;
	}
	public void setEmpSet(Set<Employee> empSet) {
		this.empSet = empSet;
	}
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", empSet=" + empSet + "]";
	}
	
	
	

}
