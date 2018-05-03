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
		
		//  新建一个输入流  获取数据库配置文件
		InputStream inputStream =  Resources.getResourceAsStream("configuration.xml");
		//  根据数据库配置文件拿到 sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//  开启一个sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//1.   做数据库查询  
		//com.dao.UserDao 需要和 UserMapper.xml中的 <mapper namespace="com.dao.UserDao"> 一致 
		// selectUserById  是 <select id="selectUserById" parameterType="int" resultType="User"> 中的id
		User user = (User)sqlSession.selectOne("com.dao.UserDao.selectUserById",new Integer(1000));
		
		System.out.println(user.toString());
		
		
	}
}
