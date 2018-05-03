package com.test;


import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.entity2.Department;
import com.entity2.Employee;
import com.util.MybatisUtil;

/**
 * 一对多  测试  新增
 * @author Administrator
 *
 */
public class Test5 {

	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
			
			Department dep = new Department();
			dep.setDepName("人事部");
			mapper.addDep(dep);
			
			Employee emp = new Employee();
			emp.setEmpName("王二麻子");
			emp.setDepat(dep);
			mapper.addEmp(emp);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
