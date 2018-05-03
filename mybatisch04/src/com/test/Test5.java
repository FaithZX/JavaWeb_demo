package com.test;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.dao.UserDao;
import com.entity.User;
import com.entity3.Department;
import com.util.MybatisUtil;

public class Test5 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			User user2 = new User();
			user2.setUsername("hahaha");
			user2.setPassword("11111111");
			user2.setAge(12);
			user2.setBirth(new Date(199999999));
			
			mapper.addUser(user2);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
