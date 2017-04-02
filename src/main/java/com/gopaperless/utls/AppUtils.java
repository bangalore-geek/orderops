package com.gopaperless.utls;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppUtils {
	
	public static String getRandorPassword(String firstName){
		String fourDigitRandomNumber = ""+((int)(Math.random()*9000)+1000);
		String thisPassword = firstName;
		thisPassword = thisPassword.replaceAll(" ", "");
		thisPassword = thisPassword.substring(0, 1).toUpperCase() + thisPassword.substring(1);
		thisPassword = thisPassword + "@" + fourDigitRandomNumber;
		
		return thisPassword;
	}
	
	public static String encryptPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

}
