package com.gopaperless.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gopaperless.model.User;
import com.gopaperless.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_USER")
	public @ResponseBody Object loadUsers(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<User> users = userService.getUsers();
		model.put("users", users);
		return model;
	}

	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
	@Secured("ROLE_DF_CREATE_USER")
	public Object saveUsers(@RequestBody User thisUser) {
		System.out.println("asve called >>>");
		Map<String, Object> model = new HashMap<String, Object>();
		userService.save(thisUser);
		return model;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_USER")
	public Object getUsers(HttpServletRequest request, @PathVariable int userId) {
		System.out.println("get user  called >>>" + userId);
		Map<String, Object> model = new HashMap<String, Object>();
		User user = userService.getUserById(userId);
		System.out.println(user.getEmail());
		model.put("users", user);
		return model;
	}
}
