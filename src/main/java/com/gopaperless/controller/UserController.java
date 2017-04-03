package com.gopaperless.controller;

import java.util.HashMap;
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

import com.gopaperless.bean.UserProfileBean;
import com.gopaperless.model.User;
import com.gopaperless.model.UserProfile;
import com.gopaperless.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_USER")
	public @ResponseBody Object loadUsers(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", userService.getUsers());
		return model;
	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_USER")
	public @ResponseBody Object loadRoles(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("roles", userService.getRoles());
		return model;
	}

	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
	@Secured("ROLE_DF_CREATE_USER")
	public Object saveUsers(@RequestBody UserProfileBean thisUserProfileBean) {
		Map<String, Object> model = new HashMap<String, Object>();
		userService.saveUserDetails(thisUserProfileBean);
		return model;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_USER")
	public Object getUsers(HttpServletRequest request, @PathVariable int userId) {
		Map<String, Object> model = new HashMap<String, Object>();
		User user = userService.getUserById(userId);
		UserProfile userProfile = userService.getUserProfileById(userId);
		UserProfileBean userProfileBean = new UserProfileBean();
		if (userProfile != null) {
			userProfileBean.setFirstName(userProfile.getFirstName());
			userProfileBean.setLastName(userProfile.getLastName());
		}
		userProfileBean.setUserName(user.getUserName());
		userProfileBean.setEmail(user.getEmail());
		userProfileBean.setActive(user.getActive());
		userProfileBean.setRoleId(user.getRole().getId());

		model.put("users", userProfileBean);
		return model;
	}
}
