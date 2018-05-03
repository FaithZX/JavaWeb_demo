package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.entity2.Department;
import com.entity2.Employee;
import com.util.MybatisUtil;

/**
 * “ª∂‘∂‡≤‚ ‘
 * @author Administrator
 *
 */
public class Test4 {

	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
			
			List<Department> selectDepat = mapper.selectDepat();
			
			for (Department dep : selectDepat) {
				System.out.println(dep.toString());
				for (Employee emp : dep.getEmpSet()) {
					System.out.println(emp.toString());
				}
			}
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
