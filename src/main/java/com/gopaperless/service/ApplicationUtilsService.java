package com.gopaperless.service;

import javax.servlet.http.HttpServletRequest;

import com.gopaperless.model.User;

public interface ApplicationUtilsService {

	public User getLoggedInUser();

	public void postAuditLog(HttpServletRequest request, String categoryCode, String description,
			Integer affectedUserId);

	public String encryptPassword(String password);

}
