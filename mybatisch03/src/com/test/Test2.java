package com.test;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;

import com.dao.UserDao;
import com.entity.User;
import com.util.MybatisUtil;

public class Test2 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			
			User user = new User();
			user.setUsername("ÍõÂé×Ó");
			user.setPassword("123312");
			user.setAge(11);
			user.setBirth(new Date(100000000));
			
			mapper.deleteUser(user);
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
