package com.zx.dao;

import java.util.List;

import com.zx.enity.User;

public interface UserDao {
	
	/**
	 * �����û�
	 * @return
	 */
	public int saveUser(User user);
	
	
	/**
	 * �����û���Ϣ���ҷ����������ݵ�����
	 * @return
	 */
	public int saveUserReturnKey(User user) ;
	
	
	/**
	 * �õ����е��û�
	 * @return
	 */
	public List<User> getAllUser();
}
