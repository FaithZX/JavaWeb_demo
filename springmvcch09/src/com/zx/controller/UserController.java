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
	 * 跳转添加用户页面
	 * @return
	 */
	@RequestMapping("addUserView")
	public String getAddUserView(Model model) {
		User user = new User("lisi", "123456", 120);
		model.addAttribute("user", user);
		return "addUser";
	}
	
	/**
	 * 往数据库添加user用户
	 * @return
	 */
	@RequestMapping("addUser")
	public String addUser(User user,BindingResult bindingResult,Model model) {
		//保存数据
		//int num = userService.saveUser(user);
		
		//插入数据并且获取主键
		int num = userService.saveUserReturnKey(user);
		
		System.out.println(num);
		System.out.println("zxxxxxxxxxxxx");
		
		if(num > 0 ) {
			model.addAttribute("msg","注册成功，请登录！！");
		}
		
		List<User> allUser = userService.getAllUser();
		for (User user2 : allUser) {
			System.out.println(user2.getUsername());
		}
		return "login";
	}
	
}
