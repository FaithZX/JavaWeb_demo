package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.dao.UserDao;
import com.entity.User;
import com.entity3.Department;
import com.util.MybatisUtil;

public class Test3 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			List<User> user = mapper.getUserList();
			for (User user2 : user) {
				System.out.println(user2.toString());
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
