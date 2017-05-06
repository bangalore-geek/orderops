package com.gopaperless.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gopaperless.bean.ChangePassworddBean;
import com.gopaperless.bean.UserProfileBean;
import com.gopaperless.model.Email;
import com.gopaperless.model.PasswordResetToken;
import com.gopaperless.model.User;
import com.gopaperless.model.UserProfile;
import com.gopaperless.service.MailService;
import com.gopaperless.service.UserService;
import com.gopaperless.utls.AppUtils;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;

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
	
	// forget password funcnality
	
	// when user put email and hit enter
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.POST)
	public ModelAndView forgetPassword(@RequestParam("email") String contactEmailId) {
		User user = userService.getUserByEmail(contactEmailId);
		if (user == null) {
			throw new UsernameNotFoundException(contactEmailId);
		} else {
			// generating token
			String token = UUID.randomUUID().toString();
			// saving token in database
			userService.saveToken(user.getId(), token);
			// generating forgotpassword link
			String forgotPasswordLink = "/changePassword?id=" + 
					user.getId() + "&token=" + token;
			// sending email
			Email thisEmail = new Email();
			thisEmail.setTo(contactEmailId);
	    	thisEmail.setSubject("Test subject");
	    	thisEmail.setBody("Forgot password link = "+forgotPasswordLink);
	    	boolean isEmailSent = mailService.sendEmail(thisEmail);
	    	System.out.println("isEmailSent: "+isEmailSent);
		}
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("email-sent-success", data);
	}
	
	// when user get the email it will hit a url it then method will come ad display the ui
	@RequestMapping(value = { "/changePassword" }, method = RequestMethod.GET)
	public ModelAndView forgetPasswordLink(@RequestParam("id") int userId, @RequestParam("token") String token) {
		Map<String, Object> model = new HashMap<String, Object>();
		PasswordResetToken passwordResetToken = userService.getPasswordResetToken(userId, token);
		// check time also
		// crosscheck with user also
		if (passwordResetToken != null) {
			model.put("token", token);
			model.put("profileNumber", userId);
			return new ModelAndView("change-password-form", model);
		}
		return null;
	}
	
	// in change password form when user hit the save button then it will come here
	@RequestMapping(value = { "/changePassword" }, method = RequestMethod.POST)
	public String heaerChangePassword(@RequestBody ChangePassworddBean thisChangePassworddBean) {
		System.out.println("last stage  >>>>>>>>>>>>>>>>>");
		PasswordResetToken passwordResetToken = userService.getPasswordResetToken(thisChangePassworddBean.getUserId(), thisChangePassworddBean.getToken());
		if (passwordResetToken != null && thisChangePassworddBean.getNewPassword().equals(thisChangePassworddBean.getConformPassword())) {
			//load account
			User thisUser =  userService.getUserById(thisChangePassworddBean.getUserId());
			thisUser.setPassword(AppUtils.encryptPassword(thisChangePassworddBean.getNewPassword()));
			userService.save(thisUser);
		}
		return null;
	}
	
	
}
