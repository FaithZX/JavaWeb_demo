package com.dao;

import java.util.List;

import com.entity.IdCard;
import com.entity.Person;

public interface PersonDao {

	/**
	 * 获取所有的人  第一种方法
	 * @return
	 */
	public List<Person> selectPerson();
	
	
	/**
	 * 获取所有的人  第二种方法
	 * @return
	 */
	public List<Person> selectPerson2();
	
	
	/**
	 * 一对一插入
	 */
	public void addIdCard(IdCard idCard);
	public void addPerson(Person person);
}
