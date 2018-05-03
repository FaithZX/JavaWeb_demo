package com.test;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.dao.UserDao;
import com.entity.User;
import com.entity3.Department;
import com.util.MybatisUtil;

public class Test6 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			User user2 = new User();
			
			user2.setUsername("¿¨¿¨Î÷");
			user2.setPassword("ÃùÈË");
			user2.setAge(12);
			user2.setBirth(new Date(9999999));
			user2.setUser_id(1016);
			
			mapper.updateUser(user2);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
