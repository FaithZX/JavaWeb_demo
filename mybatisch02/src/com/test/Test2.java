package com.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.PersonDao;
import com.entity.Person;
import com.util.MybatisUtil;

public class Test2 {

	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			PersonDao mapper = sqlSession.getMapper(PersonDao.class);
			List<Person> selectPerson = mapper.selectPerson2();
			System.out.println(selectPerson.toString());
			
			
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
