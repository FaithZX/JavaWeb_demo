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

public class Test3 {
	
	public static void main(String[] args) throws IOException {
		
		//3.��װSqlSessionFactory ������
		UserDao mapper = MybatisUtil.getInstance().getSqlSession().getMapper(UserDao.class);
		
		User user = mapper.selectUserById(1000);
		
		System.out.println(user.toString());
		
		
	}
}
