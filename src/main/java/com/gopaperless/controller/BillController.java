package com.gopaperless.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gopaperless.model.Bill;
import com.gopaperless.service.BillService;

@Controller
public class BillController {

	@Autowired
	private BillService service;

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("bills", service.findAll());
		return "home";
	}

	@RequestMapping(value = "/saveBill", method = RequestMethod.POST)
	public String addCar(@ModelAttribute Bill bill) {
		service.saveBill(bill);
		return "redirect:home";
	}

	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("bills", service.search(search));
		model.addAttribute("search", search);
		return "home";
	}

}
