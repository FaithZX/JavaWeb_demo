package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.UserDao;
import com.entity.User;
import com.util.MybatisUtil;

public class Test10 {
	
	public static void main(String[] args) throws IOException {
		
		SqlSession sqlSession = MybatisUtil.getInstance().getSqlSession();
		
		//3.封装SqlSessionFactory 的做法
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		
		User user = new User();
		user.setUsername("xxxx");
		user.setPassword("xxxxxxxx");
		user.setAge(123);
		user.setBirth(new Date(100000000));
		
		//  天假对象
		mapper.insertUser(user);
		
		
		
		sqlSession.commit();
		
	}
}
