package com.test;

import org.apache.ibatis.session.SqlSession;

import com.dao.DepartmentDao;
import com.entity3.Department;
import com.util.MybatisUtil;

/**
 * 缓存
 * @author Administrator
 *
 */
public class Test8 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getInstance().getSqlSession();
			DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
			Department dep = mapper.getDepById(3);
			System.out.println(dep.toString());
			
			System.out.println("----------------------------");
			
			//  一级缓存   从内存中取对象    注意sqlSession需要同一个
			Department dep2 = mapper.getDepById(3);
			System.out.println(dep2.toString());
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}
