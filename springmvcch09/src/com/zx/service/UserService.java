package com.zx.service;

import java.util.List;

import com.zx.enity.User;

public interface UserService {

	/**
	 * �����û�
	 * @param user
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
