package com.dao;

import java.util.List;


import com.entity2.Department;
import com.entity2.Employee;


/**
 * һ�Զ�  
 * @author Administrator
 *
 */
public interface DepartmentDao {

	
	/**
	 * һ�Զ��ѯ
	 * @return
	 */
	public List<Department> selectDepat();
	
	/**
	 * ��������
	 * @param department
	 */
	public void addDep(Department department);
	public void addEmp(Employee employee);
	
	
}
