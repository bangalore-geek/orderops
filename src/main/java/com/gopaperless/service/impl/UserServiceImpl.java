package com.gopaperless.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
