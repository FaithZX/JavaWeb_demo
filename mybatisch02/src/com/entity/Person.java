package com.entity;


public class Person {
	private int personId;
	private String username;
	private int age;
	
	/**
	 * …Ì∑›÷§
	 */
	private IdCard idCard;
	
	
	
	
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", username=" + username + ", age=" + age + ", idCard=" + idCard + "]";
	}
	
	
	
}
