package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.User;

public interface UserDao {
	
	
	/**
	 * ���������id="selectUserById"һ��
	 * <select id="selectUserById" parameterType="int" resultType="com.entity.User"> 
	 * @param id
	 * @return user
	 */
	public User selectUserById(Integer id);
	
	/**
	 * ��ѯ��������
	 */
	public List<User> selectUsers();
	
	/**
	 * ģ����ѯ  ������
	 */
	public List<User> selectUsersLike(String username);
	
	/**
	 * ģ����ѯ ������
	 */
	public List<User> selectUsersLike2(@Param(value="username")String username,
										@Param(value="id")int id);
	
	/**
	 * ģ����ѯ ������  ����
	 */
	public List<User> selectUsersLike3(@Param(value="username")String username,
										@Param(value="id")int id,
										@Param(value="orderName") String orderName,
										@Param(value="orderType") String orderType);
	
	/**
	 * ��������ѯ  �ö�����Ϊ����
	 */
	public List<User> selectUsersLike4(User user);
	
	
	/**
	 * ��������ѯ  �ö�����Ϊ����
	 */
	public List<User> selectUsersLike5(User user);
	
	/**
	 * ����һ������
	 */
	public void insertUser(User user);

	
	/**
	 * ����һ������
	 */
	public void updateUser(@Param(value="username") String username,
			@Param(value="password")String password,
			@Param(value="id")int id);
	
	
	/**
	 * ����һ������
	 */
	public List<User> selectUserByIds(List<Integer> idList);

}
