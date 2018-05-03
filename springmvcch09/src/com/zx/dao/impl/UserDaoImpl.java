package com.zx.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.zx.dao.UserDao;
import com.zx.enity.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao  {
	
	/**
	 * ��ȡ����Դ
	 * @param dataSource ��Դ�� bean.xml�����ļ���dataSource
	 */
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public int saveUser(User user) {
		int num = this.getJdbcTemplate().update("insert into user (username,password,age,birth) values (?,?,?,?)",
				new Object[] {user.getUsername(),user.getPassword(),user.getAge(),user.getBirth()});
		
		//�׳��쳣 �����Ƿ�ع�
		//int a = 1/0;
		
		return num;
	}

	@Override
	public int saveUserReturnKey(User user) {
		System.out.println(user.toString());
		// ���ܲ��������Ƿ��ص�����ֵ
		KeyHolder key = new GeneratedKeyHolder();
		// �����ݿ�������ݲ��ҷ�������ֵ
		this.getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// �����ݿ�־û�   ��������
				PreparedStatement prepareStatement = con.prepareStatement("insert into user (username,password,age,birth) values (?,?,?,?)", new String[] {"user_id"});
				//��ռλ����ֵ  ���ֱ�ʾ�ڼ���ռλ��
				prepareStatement.setString(1,user.getUsername() );
				prepareStatement.setString(2,user.getPassword());
				prepareStatement.setInt(3,user.getAge());
				prepareStatement.setDate(4,new Date(999999));
				return prepareStatement;
			}
		},key);
			//��������   ��ΪKeyHolder key��һ������  ������Ҫ����ȡ�� key ��תΪint����
		return key.getKey().intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		//�½�list���Ͻ������е��û���Ϣ
		List<User> userList = new ArrayList<User>();
		// �����ݿ�־û�  ������ userList ���ܲ�ѯ��������
		userList = this.getJdbcTemplate().query("select * from user ", new RowMapper() {
			//  ����ѭ��  ���е�������ResultSet rs ������ȡ��  Ҳ���Ը�������ȡint rowNum
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				//�½�user����   �����ݿ�ȡ�������ݱ���user��������
				User user = new User();
				//  rs.getString(2)   getString��Ҫȡ�����ݵ�����   2���������еĵڼ���
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setBirth(rs.getDate(5));
				//  ����user����    SpringJDBC���Զ���user   ��ӵ�  userList ��
				return user;
			}
		});
		return userList;
	}

}
