package com.entity4;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.annotations.Insert;

public class Group {

	private int groupId;
	private String groupName;
	
	/**
	 * ¶à¶Ô¶à
	 */
	private Set<User> userSet = new HashSet<User>();
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", userSet=" + userSet + "]";
	}
	
	
	
	
	
}
