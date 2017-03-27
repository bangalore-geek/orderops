package com.gopaperless.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gopaperless.model.User;
import com.gopaperless.service.ApplicationUtilsService;
import com.gopaperless.utls.Menu;
import com.gopaperless.utls.Navigation;

@Controller
public class NavigationController {
	
	@Autowired
	private ApplicationUtilsService utils;

	@Autowired
	private Navigation navigation;


	@Menu(parent = "root", title = "Company", url = "", accessCode = "ROLE_DF_COMPANY_MENU", order = 1, visible = false)
	public void one(HttpServletRequest request) {
	}

	@Menu(parent = "root", title = "UserAdminstration", url = "", accessCode = "ROLE_DF_USER_ADMIN", order = 1, visible = false)
	public void two(HttpServletRequest request) {
	}

	@Menu(parent = "root", title = "Dashboard", url = "", accessCode = "ROLE_DF_DASHBOARD", order = 1, visible = false)
	public void three(HttpServletRequest request) {
	}

	@Menu(parent = "root", title = "Retailer", url = "", accessCode = "ROLE_DF_RETAILER", order = 1, visible = false)
	public void four(HttpServletRequest request) {
	}

	@Menu(parent = "root", title = "Settings", url = "", accessCode = "ROLE_DF_SETTINGS", order = 1, visible = false)
	public void five(HttpServletRequest request) {
	}

	@Menu(parent = "Company", title = "Company Profile", url = "/company-profile", accessCode = "ROLE_DF_COMPANY_PROFILE", order = 1, visible = false)
	@RequestMapping("/company-profile")
	@Secured("ROLE_DF_COMPANY_PROFILE")
	public ModelAndView six(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		User loggedInUser = utils.getLoggedInUser();
		data.put("user", loggedInUser);
		data.put("menus", navigation.getMenu());
		return new ModelAndView("company-profile", data);
	}

	@Menu(parent = "Company", title = "Bank Details", url = "/bank-details", accessCode = "ROLE_DF_BANK_DETAILS", order = 1, visible = false)
	@RequestMapping("/bank-details")
	@Secured("ROLE_DF_BANK_DETAILS")
	public ModelAndView seven(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("bank-details", data);
	}

	@Menu(parent = "UserAdminstration", title = "Create User", url = "/create-user", accessCode = "ROLE_DF_CREATE_USER", order = 1, visible = false)
	@RequestMapping("/create-user")
	@Secured("ROLE_DF_CREATE_USER")
	public ModelAndView eight(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("create-users", data);
	}

	@Menu(parent = "UserAdminstration", title = "Create Roles", url = "/create-roles", accessCode = "ROLE_DF_CREATE_ROLES", order = 1, visible = false)
	@RequestMapping("/create-roles")
	@Secured("ROLE_DF_CREATE_ROLES")
	public ModelAndView nine(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("create-roles", data);
	}

	@Menu(parent = "Dashboard", title = "Sales Order", url = "/sales-order", accessCode = "ROLE_DF_DASHBOARD_SALES", order = 1, visible = false)
	@RequestMapping("/sales-order")
	@Secured("ROLE_DF_DASHBOARD_SALES")
	public ModelAndView ten(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("sales-order", data);
	}

	@Menu(parent = "Dashboard", title = "Open Orders", url = "/open-orders", accessCode = "ROLE_DF_DASHBOARD_OPENORDER", order = 1, visible = false)
	@RequestMapping("/open-orders")
	@Secured("ROLE_DF_DASHBOARD_OPENORDER")
	public ModelAndView eleven(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("open-orders", data);
	}

	@Menu(parent = "Dashboard", title = "Payment", url = "/payment-receive", accessCode = "ROLE_DF_DASHBOARD_PAYMENT", order = 1, visible = false)
	@RequestMapping("/payment-receive")
	@Secured("ROLE_DF_DASHBOARD_PAYMENT")
	public ModelAndView oneone(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("payment-receive", data);
	}

	@Menu(parent = "Retailer", title = "Retailer Screen", url = "/retailer-screen", accessCode = "ROLE_DF_RETAILER_ADD", order = 1, visible = false)
	@RequestMapping("/retailer-screen")
	@Secured("ROLE_DF_RETAILER_ADD")
	public ModelAndView twotwo(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("retailer-screen", data);
	}

	@Menu(parent = "Settings", title = "Retailer Screen", url = "/lov", accessCode = "ROLE_DF_LOV", order = 1, visible = false)
	@RequestMapping("/lov")
	@Secured("ROLE_DF_LOV")
	public ModelAndView three(Model model) {
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("lov", data);
	}

}
