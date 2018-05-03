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

public class Test2 {

	
	public static void main(String[] args) throws IOException {
		//  新建一个输入流  获取数据库配置文件
		InputStream inputStream =  Resources.getResourceAsStream("configuration.xml");
		//  根据数据库配置文件拿到 sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//  开启一个sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//2. 面向接口编程
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = mapper.selectUserById(1000);
		
		System.out.println(user.toString());
	}
}
