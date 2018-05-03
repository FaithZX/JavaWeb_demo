package com.test;

import java.util.HashMap;
import java.util.Map;

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
public class Test6 {

	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			GroupDao mapper = sqlSession.getMapper(GroupDao.class);
			Group g = new Group();
			g.setGroupName("disizu");
			mapper.addGroup(g);
			
			
			User user = new User();
			user.setUserName("王麻子");
			User user2 = new User();
			user2.setUserName("绿麻子");
			mapper.addUser(user);
			mapper.addUser(user2);
			
			Map<String, Integer> m = new HashMap<String, Integer>();
			m.put("groupId",g.getGroupId() );
			m.put("userId",user.getUserId() );
			mapper.addGroupUser(m);
			
			Map<String, Integer> m2 = new HashMap<String, Integer>();
			m2.put("groupId",g.getGroupId() );
			m2.put("userId",user2.getUserId() );
			mapper.addGroupUser(m2);
			
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
