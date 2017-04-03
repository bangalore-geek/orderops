package com.gopaperless.utls;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppUtils {

	public static String getRandorPassword(String firstName) {
		String fourDigitRandomNumber = "" + ((int) (Math.random() * 9000) + 1000);
		String password = firstName;
		password = password.replaceAll(" ", "");
		password = password.substring(0, 1).toUpperCase() + password.substring(1);
		password = password + "@" + fourDigitRandomNumber;
		return password;
	}

	public static String encryptPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

}
