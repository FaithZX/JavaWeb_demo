package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	
	//  创建一个静态的instance 变量
	private static MybatisUtil instance = null;
	//  全局的变量
	private SqlSessionFactory sqlSessionFactory;
	
	
	private MybatisUtil() {
		//  新建一个输入流  获取数据库配置文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//  根据数据库配置文件拿到 sqlSessionFactory
	}
	
	
	//  get 方法
	public static MybatisUtil getInstance() {
		// instance 为空就调用MybatisUtil构造函数
		if(instance == null){
			instance = new MybatisUtil();
		}
		// 下次去调用就不会重新去调用MybatisUtil构造函数  重新获取sqlSessionFactory
		return instance;
	}
	
	
	/**
	 * 获取SqlSession  做数据库持久化
	 * @return
	 */
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	
	public void closeSqlSession(SqlSession session) {
		session.close();
	}
	
	
	
	
	
	
	
	
}
