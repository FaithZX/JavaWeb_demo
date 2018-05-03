package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.UserDao;
import com.entity.User;
import com.util.MybatisUtil;

public class Test7 {
	
	public static void main(String[] args) throws IOException {
		
		//3.封装SqlSessionFactory 的做法
		UserDao mapper = MybatisUtil.getInstance().getSqlSession().getMapper(UserDao.class);
		
		//  获取集合数据   
		List<User> user = mapper.selectUsersLike3("%lisi%",1001,"user_id","desc");
		
		for (int i = 0; i < user.size(); i++) {
			System.out.println(user.get(i).toString());
			
		}
		
		
		
		
	}
}
