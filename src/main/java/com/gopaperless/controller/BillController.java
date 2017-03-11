package com.gopaperless.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gopaperless.model.User;
import com.gopaperless.service.ApplicationUtilsService;
import com.gopaperless.utls.Navigation;

@Controller
public class BillController {

	@Autowired
	private ApplicationUtilsService utils;

	@Autowired
	private Navigation navigation;

	@RequestMapping("/")
	public ModelAndView home(Model model) {
		Map<String, Object> data = new HashMap<>();
		User loggedInUser = utils.getLoggedInUser();
		data.put("user", loggedInUser);
		data.put("menus", navigation.getMenu());		
		return new ModelAndView("home", data);
	}

}
