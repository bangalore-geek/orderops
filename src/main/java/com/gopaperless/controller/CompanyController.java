package com.gopaperless.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopaperless.model.User;
import com.gopaperless.service.UserService;

@RestController
public class CompanyController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/save-user")
	public Object home(Model model) {
		Map<String, Object> data = new HashMap<>();
		User user = new User();
		user.setBriefcasePassword("sa");
		user.setCreatedDate(new Date());
		user.setEmail("deepak@deepak.com");
		user.setModifiedDate(new Date());
		user.setName("DDDDDD");
		user.setPassword("sa");
		user.setUserName("ddddddd");
		user.setUserType(1);
		
		userService.save(user);
		
		return data;
	}

}
