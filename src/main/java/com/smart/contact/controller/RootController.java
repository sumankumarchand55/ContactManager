package com.smart.contact.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.smart.contact.helper.Helper;
import com.smart.contact.model.User;
import com.smart.contact.service.UserService;

@ControllerAdvice
public class RootController {
private Logger logger=LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	 @ModelAttribute
	public void addLogedInUserInformation(Model model,Authentication authentication){
		 if(authentication==null) {
			 return;
		 }
		System.out.println("Adding google user imformation in model");

		String username=Helper.getEmailOfLoggedInUser(authentication);
		logger.info("User logged in: {}",username);
		User user=userService.getUserByEmail(username);

		    System.out.println(user);
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			model.addAttribute("logedInUser",user);
		}

	}

