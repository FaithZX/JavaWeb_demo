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

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		//  �½�һ��������  ��ȡ���ݿ������ļ�
		InputStream inputStream =  Resources.getResourceAsStream("configuration.xml");
		//  �������ݿ������ļ��õ� sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//  ����һ��sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//1.   �����ݿ��ѯ  
		//com.dao.UserDao ��Ҫ�� UserMapper.xml�е� <mapper namespace="com.dao.UserDao"> һ�� 
		// selectUserById  �� <select id="selectUserById" parameterType="int" resultType="User"> �е�id
		User user = (User)sqlSession.selectOne("com.dao.UserDao.selectUserById",new Integer(1000));
		
		System.out.println(user.toString());
		
		
	}
}
