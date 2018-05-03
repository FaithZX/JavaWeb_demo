package com.test;

import org.apache.ibatis.session.SqlSession;

import com.dao.GroupDao;
import com.util.MybatisUtil;

/**
 * 一对多  测试  新增
 * @author Administrator
 *
 */
public class Test8 {

	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			GroupDao mapper = sqlSession.getMapper(GroupDao.class);
			
			mapper.deleteGroupUser(6);
			
			
			mapper.deleteGroup(6);
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
