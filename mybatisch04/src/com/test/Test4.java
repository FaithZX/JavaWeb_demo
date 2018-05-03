package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.dao.UserDao;
import com.entity.User;
import com.entity3.Department;
import com.util.MybatisUtil;

public class Test4 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			User user2 = new User();
			user2.setUsername("%lisi%");
			user2.setUser_id(1006);
			List<User> user = mapper.getUserByUser(user2);
			for (User u : user) {
				System.out.println(u.toString());
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
