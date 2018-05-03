package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.UserDao;
import com.entity.User;
import com.util.MybatisUtil;

public class Test12 {
	
	public static void main(String[] args) throws IOException {
		
		//sqlSession.commit();
		SqlSession sqlSession = MybatisUtil.getInstance().getSqlSession();
		try {
			//3.封装SqlSessionFactory 的做法
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			
			//  更新对象
			//mapper.updateUser("wwwwwwww", "wwwwwww", 1001);
			List<Integer> idList = new ArrayList<Integer>();
			idList.add(1001);
			idList.add(1003);
			List<User> selectUserByIds = mapper.selectUserByIds(idList);
			System.out.println(selectUserByIds.toString());
			
		} catch (Exception e) {
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		
		
		
	}
}
