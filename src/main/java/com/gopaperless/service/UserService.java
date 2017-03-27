package com.gopaperless.service;

import java.util.List;

import com.gopaperless.model.User;

public interface UserService {

	public User getUser(String login);

	public List<User> getUsers();

	public void save(User thisUser);

	public User getUserById(int userId);

}
