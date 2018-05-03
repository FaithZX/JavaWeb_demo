package com.zx.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5940906494055279948L;
	
	private int user_id;
	private String username;
	private String password;
	private int age;
	private Date birth;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", birth=" + birth + "]";
	}
	
	
	
	
	
	
}
