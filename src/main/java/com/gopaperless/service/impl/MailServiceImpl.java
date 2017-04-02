package com.gopaperless.service.impl;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.gopaperless.model.Email;
import com.gopaperless.service.MailService;


@Service("mailService") 
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender javaMailSenderImpl;

	@Override
	public boolean sendEmail(Email email) {
		MimeMessagePreparator preparator = getMessagePreparator(email);
		try {
			javaMailSenderImpl.send(preparator);
			return true;
		} catch (MailException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	private MimeMessagePreparator getMessagePreparator(final Email email) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
				mimeMessage.setText(email.getBody());
				mimeMessage.setSubject(email.getSubject());
			}
		};
		return preparator;
	}
}