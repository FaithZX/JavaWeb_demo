package com.test2;

import java.util.Date;

public class User {

	
	private int id; 
	private String username;
	private String password;
	private String sex;
	private int age;
	private Date birth;
	
	
	
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", age=" + age
				+ ", birth=" + birth + "]";
	}
	
	public User() {};
	public User(int id, String username, String password, String sex, int age, Date birth) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.birth = birth;
	}

	
	
	
	
	
}
