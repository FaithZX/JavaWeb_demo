package com.zx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zx.entity.User;
import com.zx.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 跳转添加用户页面
	 * @return
	 */
	@RequestMapping("loginView")
	public String getAddUserView(Model model) {
		int num = userService.getUserCount();
		model.addAttribute("num",num);
		return "login";
	}
	
	
	
}
