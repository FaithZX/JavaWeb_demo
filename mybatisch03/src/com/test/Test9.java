package com.test;


import org.apache.ibatis.session.SqlSession;

import com.dao.UserDao;
import com.util.MybatisUtil;

public class Test9 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			
			System.out.println(mapper.getDep(3));
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
