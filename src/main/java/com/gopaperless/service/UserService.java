package com.gopaperless.service;

import java.util.List;

import com.gopaperless.bean.UserProfileBean;
import com.gopaperless.model.Address;
import com.gopaperless.model.Role;
import com.gopaperless.model.User;
import com.gopaperless.model.UserProfile;

public interface UserService {

	public User getUser(String login);

	public List<User> getUsers();

	public void save(User thisUser);

	public User getUserById(int userId);
	
	public List<Role> getRoles();

	public void saveUserDetails(UserProfileBean userProfileBean);
	
	public UserProfile getUserProfileById(int userId);
	
	public Address getUserAddressById(int userId);
}
