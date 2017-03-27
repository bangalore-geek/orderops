package com.gopaperless.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopaperless.model.User;
import com.gopaperless.repository.UserDao;
import com.gopaperless.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDAO;

	public User getUser(String login) {
		return userDAO.getUser(login);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public void save(User thisUser) {
		userDAO.save(thisUser);
	}

	@Override
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}

}
