package com.dao;

import java.util.List;


import com.entity2.Department;
import com.entity2.Employee;


/**
 * 一对多  
 * @author Administrator
 *
 */
public interface DepartmentDao {

	
	/**
	 * 一对多查询
	 * @return
	 */
	public List<Department> selectDepat();
	
	/**
	 * 插入数据
	 * @param department
	 */
	public void addDep(Department department);
	public void addEmp(Employee employee);
	
	
}
