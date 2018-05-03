package com.test;

import org.apache.ibatis.session.SqlSession;

import com.dao.PersonDao;
import com.entity.IdCard;
import com.entity.Person;
import com.util.MybatisUtil;

public class Test3 {

	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			PersonDao mapper = sqlSession.getMapper(PersonDao.class);
			
			IdCard ic = new IdCard();
			ic.setCardNum("000000");
			mapper.addIdCard(ic);
			
			System.out.println(ic.getCard_id());
			
			Person p = new Person();
			p.setUsername("ccccc");
			p.setAge(12);
			p.setIdCard(ic);
			
			mapper.addPerson(p);
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
