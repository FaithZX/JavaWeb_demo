package com.test;


import org.apache.ibatis.session.SqlSession;
import com.dao.GroupDao;
import com.entity3.Group;
import com.entity3.User;
import com.util.MybatisUtil;

/**
 * 一对多  测试  新增
 * @author Administrator
 *
 */
public class Test7 {

	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			GroupDao mapper = sqlSession.getMapper(GroupDao.class);
			
			for (Group g : mapper.selectGroup()) {
				System.out.println(g.toString());
				for (User u : g.getUserSet()) {
					System.out.println(u.toString());
				}
			}
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
