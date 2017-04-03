package com.gopaperless.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopaperless.bean.UserProfileBean;
import com.gopaperless.model.Address;
import com.gopaperless.model.Role;
import com.gopaperless.model.User;
import com.gopaperless.model.UserProfile;
import com.gopaperless.repository.RoleDao;
import com.gopaperless.repository.UserDao;
import com.gopaperless.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDAO;

	@Autowired
	private RoleDao roleDAO;

	public User getUser(String login) {
		return userDAO.getUser(login);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<User> getUsers() {
		Set set = new HashSet(userDAO.getUsers());
		List<User> users = new ArrayList(set);
		return users;
	}

	@Override
	public void save(User thisUser) {
		userDAO.save(thisUser);
	}

	@Override
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}

	@Override
	public UserProfile getUserProfileById(int userId) {
		return userDAO.getUserProfileById(userId);
	}

	@Override
	public Address getUserAddressById(int userId) {
		return userDAO.getUserAddressById(userId);
	}

	@Override
	public void saveUserDetails(UserProfileBean userProfileBean) {
		userDAO.saveUserDetails(userProfileBean);
	}
}
