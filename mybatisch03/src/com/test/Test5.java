package com.test;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.UserDao;
import com.entity.User;
import com.util.MybatisUtil;

public class Test5 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			
			/**
			 * 已经到第2页了
			 * 每页显示3条
			 */
			List<User> userAll = mapper.userList(3*2, 3);
			System.out.println(userAll);
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
