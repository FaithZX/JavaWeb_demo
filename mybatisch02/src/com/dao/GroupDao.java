package com.dao;

import java.util.List;
import java.util.Map;

import com.entity3.Group;
import com.entity3.User;

@SuppressWarnings("rawtypes")
public interface GroupDao {

	/**
	 * ����
	 * @param user
	 */
	public void addUser(User user);
	public void addGroup(Group group);
	public void addGroupUser(Map groupAndUser);
	
	/**
	 * ��ѯ
	 */
	public List<Group> selectGroup();
	
	/**
	 * ɾ��
	 */
	public void deleteGroupUser(int id);
	public void deleteGroup(int id);
}
