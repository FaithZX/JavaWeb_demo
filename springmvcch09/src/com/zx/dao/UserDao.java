package com.zx.dao;

import java.util.List;

import com.zx.enity.User;

public interface UserDao {
	
	/**
	 * 保存用户
	 * @return
	 */
	public int saveUser(User user);
	
	
	/**
	 * 保存用户信息并且返回这条数据的主键
	 * @return
	 */
	public int saveUserReturnKey(User user) ;
	
	
	/**
	 * 拿到所有的用户
	 * @return
	 */
	public List<User> getAllUser();
}
