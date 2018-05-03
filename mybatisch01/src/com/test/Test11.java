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

public class Test11 {
	
	public static void main(String[] args) throws IOException {
		
		SqlSession sqlSession = MybatisUtil.getInstance().getSqlSession();
		
		//3.封装SqlSessionFactory 的做法
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		
		//  更新对象
		//mapper.updateUser("wwwwwwww", "wwwwwww", 1001);
		mapper.updateUser("111111", null, 1001);
		
		sqlSession.commit();
		
	}
}
