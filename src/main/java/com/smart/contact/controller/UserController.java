package com.smart.contact.controller;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.contact.config.OAuthAuthenticationSuccessHandler;
import com.smart.contact.model.Contact;
import com.smart.contact.model.User;
import com.smart.contact.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(OAuthAuthenticationSuccessHandler.class);

	@GetMapping("/index")
	public String dashboard(Model model) {
		return "/afterlogin/user_dashboard";

	}
	@GetMapping("/profile")
	public String userProfile(Model model) {
		return "/afterlogin/profile";

	}
	
	@PostMapping("/disable/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> disableUser(@PathVariable int id) {
	    Map<String, String> response = new HashMap<>();
	    try {
	        User user = userService.getUserById(id);
	        if (user == null) {
	            response.put("message", "User Not Found");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	        userService.disableUser(id);
	        response.put("message", "User Disabled successfully");
	        return ResponseEntity.ok(response);
	        
	    } catch (Exception e) {
	        response.put("message", "Error: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

}
