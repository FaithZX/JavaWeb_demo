package com.zx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zx.enity.User;
import com.zx.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * ��ת����û�ҳ��
	 * @return
	 */
	@RequestMapping("addUserView")
	public String getAddUserView(Model model) {
		User user = new User("lisi", "123456", 120);
		model.addAttribute("user", user);
		return "addUser";
	}
	
	/**
	 * �����ݿ����user�û�
	 * @return
	 */
	@RequestMapping("addUser")
	public String addUser(User user,BindingResult bindingResult,Model model) {
		//��������
		//int num = userService.saveUser(user);
		
		//�������ݲ��һ�ȡ����
		int num = userService.saveUserReturnKey(user);
		
		System.out.println(num);
		System.out.println("zxxxxxxxxxxxx");
		
		if(num > 0 ) {
			model.addAttribute("msg","ע��ɹ������¼����");
		}
		
		List<User> allUser = userService.getAllUser();
		for (User user2 : allUser) {
			System.out.println(user2.getUsername());
		}
		return "login";
	}
	
}
