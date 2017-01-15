package com.gopaperless.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gopaperless.model.AuditLogEntry;
import com.gopaperless.model.User;
import com.gopaperless.repository.UserDao;
import com.gopaperless.service.ApplicationUtilsService;
import com.gopaperless.service.PublicManager;

@Service
@Transactional(readOnly = true)
public class ApplicationUtilsServiceImpl implements ApplicationUtilsService {

	@Autowired
	private PublicManager publicManager;

	@Autowired
	private UserDao dao;

	@Override
	public User getLoggedInUser() {
		return dao.getLoggedInUser();
	}

	@Override
	@Transactional(readOnly = false)
	public void postAuditLog(HttpServletRequest request, String categoryCode, String description,
			Integer affectedUserId) {
		User user = dao.getLoggedInUser();
		saveAuditLogEntry(categoryCode, user, request.getRemoteAddr(), description, affectedUserId);
	}

	@Transactional(readOnly = false)
	private void saveAuditLogEntry(String categoryCode, User user, String remoteAddr, String description,
			Integer affectedUserId) {
		AuditLogEntry entry = new AuditLogEntry(user, remoteAddr, description, affectedUserId);
		entry.setAuditCategory(getAuditLogId(categoryCode));
		publicManager.saveObject(entry);

	}

	private int getAuditLogId(String categoryCode) {

		/*
		 * AuditLogCategory auditLogCategory = dao
		 * .getAuditLogCategory(categoryCode); if (auditLogCategory == null) {
		 * auditLogCategory = new AuditLogCategory();
		 * auditLogCategory.setCode(categoryCode);
		 * auditLogCategory.setDescription(categoryCode);
		 * publicManager.saveObject(auditLogCategory); } return auditLogCategory
		 * != null ? auditLogCategory.getId() : 0;
		 */
		return 0;
	}

	@Override
	public String encryptPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

}
