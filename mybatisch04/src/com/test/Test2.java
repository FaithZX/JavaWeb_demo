package com.test;

import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.dao.UserDao;
import com.entity.User;
import com.entity3.Department;
import com.util.MybatisUtil;

public class Test2 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			User user = mapper.getUserById(1001);
			System.out.println(user.toString());
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
