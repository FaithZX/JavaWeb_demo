package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.entity.User;
import com.sqlBuilder.UserSql;


public interface UserDao {
	
	/**
	 * ����id��ȡuser����
	 * @param id
	 * @return
	 */
	@SelectProvider(type=UserSql.class,method="getUserByIdSql")
	public User getUserById(@Param("id") int id);
	
	
	/**
	 * ��ȡ���еĶ���
	 * @return
	 */
	@SelectProvider(type=UserSql.class,method="getUserListSql")
	public List<User> getUserList();

	
	/**
	 * ����user�����ȡuser����
	 * @param id
	 * @return
	 */
	@SelectProvider(type=UserSql.class,method="getUserSql")
	public List<User> getUserByUser(User user);
	
	
	/**
	 * ����user����
	 */
	@InsertProvider(type=UserSql.class,method="addUserSql")
	@Options(useGeneratedKeys=true,keyProperty="user_id")
	public void addUser(User user);
	
	
	@UpdateProvider(type=UserSql.class,method="updateUserSql")
	public void updateUser(User user);
}
