package com.valtech.poc.lifecare.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.valtech.poc.lifecare.entity.SOSCardDetails;
import com.valtech.poc.lifecare.entity.Users;
import com.valtech.poc.lifecare.model.SOSCardDetailsModel;
import com.valtech.poc.lifecare.model.UsersModel;
import com.valtech.poc.lifecare.service.UsersService;

@Controller
public class UserDetailsController {

	@Autowired
	private UsersService usersService;

	@PostMapping("/registration")
	public String handleRegistration(@ModelAttribute("user") UsersModel usersModel,
			SOSCardDetailsModel sosCardDetailsModel, Model model, RedirectAttributes redirectAttributes,
			Principal principal, @RequestParam("sosCardDetails1") boolean sosCardDetails1,
			@RequestParam(value = "sosCardDetails", required = false) String sosCardDetails) {

		Users users = usersService.findUserByEmail(usersModel.getEmail());
		if (users == null) {
			if (usersModel.getPassword().equals(usersModel.getConfirmPassword())) {
				if (!sosCardDetails1) {
					usersService.createUserDetails(usersModel.getUsersDetail());
					redirectAttributes.addFlashAttribute("registrationSuccess", true);
					return "redirect:/login";
				} else {
					SOSCardDetails cardDetails = usersService.findByUserGovernmentUID(sosCardDetails);
					if (cardDetails != null) {
						usersService.createUserDetails(usersModel.getUsersDetail());
						redirectAttributes.addFlashAttribute("registrationSuccess", true);
						return "redirect:/login";
					} else {
						model.addAttribute("message", "GovernmentUID Doesn't match");
						return "registration";
					}
				}
			} else {
				model.addAttribute("message", "Password and Confirm Password Doesn't match");
				return "registration";
			}
		} else {
			model.addAttribute("message", "User with email Id already exists");
			return "registration";
		}

	}

	@GetMapping("/registration")
	public String getRegisterForm(@ModelAttribute("user") Users users) {

		return "registration";
	}

	@GetMapping("/login")
	public String login(Model model) {

		if (model.containsAttribute("registrationSuccess")) {
			model.addAttribute("registrationSuccessMessage", "Registration successful! Please login.");
		}

		return "login";
	}
        @GetMapping("/seller")
	public String seller() {
		return "seller";
	}
	
	@GetMapping("/buyer")
	public String buyer() {
		return "buyer";
	}
}
