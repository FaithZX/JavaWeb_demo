package com.zx.service;

import java.util.List;

import com.zx.enity.User;

public interface UserService {

	/**
	 * 保存用户
	 * @param user
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
