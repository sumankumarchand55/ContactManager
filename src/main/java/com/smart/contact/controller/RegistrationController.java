package com.smart.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.contact.helper.MessagePopup;
import com.smart.contact.model.User;
import com.smart.contact.service.UserService;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;


	@PostMapping(value = "/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,
	                                           Model model, RedirectAttributes redirAttrs ) {

		try {
	        if(result.hasErrors()) {
	        	model.addAttribute("user",user);
		    	 return "signup";
             	}
	        // Save user
	        userService.saveUser(user);
	        System.out.println(user);
			/*
			 * redirAttrs.addFlashAttribute("name", user.getName());
			 * redirAttrs.addFlashAttribute("user_name", user.getEmail());
			 * redirAttrs.addFlashAttribute("regd_no", user.getGeneratedUserId());
			 * redirAttrs.addFlashAttribute("message", new
			 * MessagePopup("SUCCESS!!!! Congratulations , You are now a new user of ContactManager.fun "
			 * , "alert-success")); return "redirect:/success";
			 */
	        model.addAttribute("email", user.getEmail());
	        return "emailverify";

	    } catch (Exception e) {
	        model.addAttribute("user", user);
	        redirAttrs.addFlashAttribute("message", new MessagePopup("ERROR!!! , Email Id Already Registered With Us!!!!", "alert-danger"));

			/*
			 * redirAttrs.addFlashAttribute("message", new MessagePopup("Error: " +
			 * e.getMessage(), "alert-danger"));
			 */
	        return "redirect:/signup";
	    }
	}
	}

