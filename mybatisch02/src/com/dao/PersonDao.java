package com.dao;

import java.util.List;

import com.entity.IdCard;
import com.entity.Person;

public interface PersonDao {

	/**
	 * ��ȡ���е���  ��һ�ַ���
	 * @return
	 */
	public List<Person> selectPerson();
	
	
	/**
	 * ��ȡ���е���  �ڶ��ַ���
	 * @return
	 */
	public List<Person> selectPerson2();
	
	
	/**
	 * һ��һ����
	 */
	public void addIdCard(IdCard idCard);
	public void addPerson(Person person);
}
