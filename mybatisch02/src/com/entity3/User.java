package com.entity3;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private int userId;
	private String userName;

	/**
	 * ¶à¶Ô¶à
	 */
	private Set<Group> groupSet = new HashSet<Group>();
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public Set<Group> getGroupSet() {
		return groupSet;
	}
	public void setGroupSet(Set<Group> groupSet) {
		this.groupSet = groupSet;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
	
	

}
