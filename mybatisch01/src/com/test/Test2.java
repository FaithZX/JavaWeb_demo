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
		//  �½�һ��������  ��ȡ���ݿ������ļ�
		InputStream inputStream =  Resources.getResourceAsStream("configuration.xml");
		//  �������ݿ������ļ��õ� sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//  ����һ��sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//2. ����ӿڱ��
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = mapper.selectUserById(1000);
		
		System.out.println(user.toString());
	}
}
