package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	
	//  ����һ����̬��instance ����
	private static MybatisUtil instance = null;
	//  ȫ�ֵı���
	private SqlSessionFactory sqlSessionFactory;
	
	
	private MybatisUtil() {
		//  �½�һ��������  ��ȡ���ݿ������ļ�
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//  �������ݿ������ļ��õ� sqlSessionFactory
	}
	
	
	//  get ����
	public static MybatisUtil getInstance() {
		// instance Ϊ�վ͵���MybatisUtil���캯��
		if(instance == null){
			instance = new MybatisUtil();
		}
		// �´�ȥ���þͲ�������ȥ����MybatisUtil���캯��  ���»�ȡsqlSessionFactory
		return instance;
	}
	
	
	/**
	 * ��ȡSqlSession  �����ݿ�־û�
	 * @return
	 */
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	
	public void closeSqlSession(SqlSession session) {
		session.close();
	}
	
	
	
	
	
	
	
	
}
