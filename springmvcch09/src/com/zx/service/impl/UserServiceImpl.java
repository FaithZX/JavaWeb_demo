package com.zx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.dao.UserDao;
import com.zx.enity.User;
import com.zx.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userdao;
	
	
	@Transactional //����ܿ�
	@Override
	public int saveUser(User user) {
		try {
			return userdao.saveUser(user);
		} catch (Exception e) {
			// �׳��쳣 ���ڱ���ع�
			throw new RuntimeException();
		}
	}

	@Transactional
	@Override
	public int saveUserReturnKey(User user) {
		try {
			return userdao.saveUserReturnKey(user);
		} catch (Exception e) {
			// �׳��쳣 ���ڱ���ع�
			throw new RuntimeException();
		}
	}
	

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userdao.getAllUser();
	}
	

}
