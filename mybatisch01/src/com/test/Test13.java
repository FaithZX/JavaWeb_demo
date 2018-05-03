package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.UserDao;
import com.entity.User;
import com.util.MybatisUtil;

public class Test13 {
	
	public static void main(String[] args) throws IOException {
		
		//3.封装SqlSessionFactory 的做法
		
		
		SqlSession sqlSession = null;
		SqlSession sqlSession2 = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			User user = mapper.selectUserById(1000);
			System.out.println(user.toString());
			sqlSession.commit();
			System.out.println("==============================================");
			
			sqlSession2 = MybatisUtil.getInstance().getSqlSession();
			UserDao mapper2 = sqlSession2.getMapper(UserDao.class);
			User user2 = mapper2.selectUserById(1000);
			sqlSession2.commit();
			System.out.println(user2.toString());
		
		} catch (Exception e) {
			// TODO: handle exception
			sqlSession.rollback();
			sqlSession2.rollback();
		}finally {
			sqlSession.close();
			sqlSession2.close();
		}
		
		
		
	}
}
