package com.gopaperless.service;

import com.gopaperless.model.Email;


public interface MailService { 
	public boolean sendEmail(Email email);
}
