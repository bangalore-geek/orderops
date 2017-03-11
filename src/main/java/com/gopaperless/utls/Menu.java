package com.gopaperless.utls;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Menu {

	int order();

	String accessCode();

	boolean visible();

	String title();
	
	String url();
	
	String parent();
}