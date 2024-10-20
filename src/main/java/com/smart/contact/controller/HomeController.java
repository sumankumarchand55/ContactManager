package com.smart.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.contact.model.Message;
import com.smart.contact.model.User;

@Controller
public class HomeController {

	@GetMapping("/")
     public String home(Model model) {
       model.addAttribute("isHomePage", true);
       return "home";
     }
    @GetMapping("/about")
    public String about(Model model) {
		model.addAttribute("title","About-ContactManager");
	  return "about";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
    	Message message=new Message();
		model.addAttribute("message",message);
	  return "contact";
    }
    @GetMapping("/meetus")
    public String meetTheTeam(Model model) {
    	 model.addAttribute("isMeetUsPage", true);
	  return "meetus";
    }
    @GetMapping("/service")
    public String service(Model model) {
    	 model.addAttribute("isServicePage", true);
	  return "service";
    }
    @GetMapping("/gallery")
    public String gallery(Model model) {
    	 model.addAttribute("title","Gallery-ContactManager");
	  return "gallery";
    }
        @GetMapping("/signup")
    public String signup(Model model) {
		model.addAttribute("title","Register-ContactManager");
		User user=new User();
		model.addAttribute("user",user);
	    return "signup";
    }
    @GetMapping("/success")
    public String success(Model model) {
		model.addAttribute("title","Successfully registered");
	  return "success";
    }
    @GetMapping("/message-success")
    public String messageSuccess() {
	  return "message-success";
    }

    @GetMapping("/login")
    public String login(Model model) {
		model.addAttribute("title","Login-ContactManager");
	  return "login";
    }

}
