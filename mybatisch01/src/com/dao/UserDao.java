package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.User;

public interface UserDao {
	
	
	/**
	 * 方法名需和id="selectUserById"一致
	 * <select id="selectUserById" parameterType="int" resultType="com.entity.User"> 
	 * @param id
	 * @return user
	 */
	public User selectUserById(Integer id);
	
	/**
	 * 查询多条数据
	 */
	public List<User> selectUsers();
	
	/**
	 * 模糊查询  单条件
	 */
	public List<User> selectUsersLike(String username);
	
	/**
	 * 模糊查询 多条件
	 */
	public List<User> selectUsersLike2(@Param(value="username")String username,
										@Param(value="id")int id);
	
	/**
	 * 模糊查询 多条件  排序
	 */
	public List<User> selectUsersLike3(@Param(value="username")String username,
										@Param(value="id")int id,
										@Param(value="orderName") String orderName,
										@Param(value="orderType") String orderType);
	
	/**
	 * 多条件查询  用对象做为参数
	 */
	public List<User> selectUsersLike4(User user);
	
	
	/**
	 * 多条件查询  用对象做为参数
	 */
	public List<User> selectUsersLike5(User user);
	
	/**
	 * 插入一个对象
	 */
	public void insertUser(User user);

	
	/**
	 * 跟新一个对象
	 */
	public void updateUser(@Param(value="username") String username,
			@Param(value="password")String password,
			@Param(value="id")int id);
	
	
	/**
	 * 跟新一个对象
	 */
	public List<User> selectUserByIds(List<Integer> idList);

}
