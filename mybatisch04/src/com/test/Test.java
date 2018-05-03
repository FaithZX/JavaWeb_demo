package com.test;

import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.entity3.Department;
import com.util.MybatisUtil;

public class Test {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
			Department dep = mapper.getDepById(3);
			System.out.println(dep.toString());
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
