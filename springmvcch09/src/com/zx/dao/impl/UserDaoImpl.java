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
	 * 获取数据源
	 * @param dataSource 来源于 bean.xml配置文件的dataSource
	 */
	@Resource
	public final void setJdbcDaoDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public int saveUser(User user) {
		int num = this.getJdbcTemplate().update("insert into user (username,password,age,birth) values (?,?,?,?)",
				new Object[] {user.getUsername(),user.getPassword(),user.getAge(),user.getBirth()});
		
		//抛出异常 测试是否回滚
		//int a = 1/0;
		
		return num;
	}

	@Override
	public int saveUserReturnKey(User user) {
		System.out.println(user.toString());
		// 接受插入数据是返回的主键值
		KeyHolder key = new GeneratedKeyHolder();
		// 往数据库插入数据并且返回主键值
		this.getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 做数据库持久化   插入数据
				PreparedStatement prepareStatement = con.prepareStatement("insert into user (username,password,age,birth) values (?,?,?,?)", new String[] {"user_id"});
				//给占位符赋值  数字表示第几个占位符
				prepareStatement.setString(1,user.getUsername() );
				prepareStatement.setString(2,user.getPassword());
				prepareStatement.setInt(3,user.getAge());
				prepareStatement.setDate(4,new Date(999999));
				return prepareStatement;
			}
		},key);
			//返回主键   因为KeyHolder key是一个对象  所以需要从中取出 key 并转为int类型
		return key.getKey().intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		//新建list集合接受所有的用户信息
		List<User> userList = new ArrayList<User>();
		// 做数据库持久化  并且用 userList 接受查询出来数据
		userList = this.getJdbcTemplate().query("select * from user ", new RowMapper() {
			//  类似循环  所有的数据在ResultSet rs 对象中取，  也可以根据行数取int rowNum
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				//新建user对象   从数据库取到的数据保存user的属性中
				User user = new User();
				//  rs.getString(2)   getString是要取的数据的类型   2是属性在行的第几列
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setBirth(rs.getDate(5));
				//  返回user对象    SpringJDBC会自动将user   添加到  userList 中
				return user;
			}
		});
		return userList;
	}

}
