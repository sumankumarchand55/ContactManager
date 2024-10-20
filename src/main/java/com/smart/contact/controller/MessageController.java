package com.smart.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.smart.contact.model.Message;
import com.smart.contact.repository.MessageRepository;

import jakarta.validation.Valid;

@Controller
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepository;

	@PostMapping("/contact")
	public String sentMessage(@Valid @ModelAttribute("message") Message message,
			BindingResult result, Model model) {	
	
		try {
	        if(result.hasErrors()) {
	        	model.addAttribute("message",message);
		    	 return "contact";
             	}
	        messageRepository.save(message);
	        return "message-success";
	        
		 } catch (Exception e) {
			    model.addAttribute("message",message);
		        return "redirect:/contact";
		    }

	}
}

