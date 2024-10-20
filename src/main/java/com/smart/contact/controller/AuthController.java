package com.smart.contact.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.contact.helper.MessagePopup;
import com.smart.contact.model.User;
import com.smart.contact.repository.UserRepository;
import com.smart.contact.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;

	@GetMapping("/verify-email")
	public String verifyEmail(@RequestParam("token") String token, RedirectAttributes redirAttrs) {
		User user = userRepository.findByemailToken(token).orElse(null);
		if (user != null) {
			if (user.getEmailToken().equals(token)) {
				user.setEmailVeryfied(true);
				user.setEnabled(true);
			    user.setEmailToken(null);
				userRepository.save(user);
				System.out.println(user);
				redirAttrs.addFlashAttribute("name", user.getName());
				redirAttrs.addFlashAttribute("user_name", user.getEmail());
				redirAttrs.addFlashAttribute("regd_no", user.getGeneratedUserId());
				redirAttrs.addFlashAttribute("message",
						new MessagePopup("Email Veryfication Successfull", "alert-success"));
				return "redirect:/success";
			}
			return "error-page";
		}
		return "error-page";
	}
	
	@PostMapping("/resend-verification")
	public String resendVerificationEmail(@RequestParam("email") String email, RedirectAttributes redirAttrs,Model model) {
	    try {
	        userService.resendVerificationEmail(email);
	        redirAttrs.addFlashAttribute("message", new MessagePopup("Verification email resent successfully.", "alert-success"));
	        model.addAttribute("email",email);
	        return "resend-email-verify";
	    } catch (Exception e) {
	        redirAttrs.addFlashAttribute("message", new MessagePopup("Error: " + e.getMessage(), "alert-danger"));
	    }
	    return "emailverify"; // Change this to the appropriate redirect page
	}


	@GetMapping("/forgot-password")
	public String showForgotPasswordForm() {
		return "reset-password-request"; // Return the name of your HTML file
	}

	@PostMapping("/forgot-password")
	public String handleForgotPassword(@RequestParam("email") String email, RedirectAttributes redirAttrs) {
		try {
			Optional<User> optionalUser = userRepository.findByEmail(email);
			if (optionalUser.isPresent()) {
				User user = optionalUser.get();
				if (user.getProviderUserId() != null) {
					redirAttrs.addFlashAttribute("message",
							"You have signed in through Google. You cannot change your password manually.Please sign in through Google.");
					return "redirect:/auth/forgot-password"; 
				}
				userService.sendPasswordResetEmail(email);
				redirAttrs.addFlashAttribute("message", "A password reset link has been sent to your email.");
			} else {
				redirAttrs.addFlashAttribute("message", "User not found with this email address.");
			}
		} catch (UsernameNotFoundException e) {
			redirAttrs.addFlashAttribute("message", "User not found with this email address.");
		}

		return "redirect:/auth/forgot-password"; 
	}

	@GetMapping("/reset-password")
	public String resetPassword(@RequestParam("token") String token, Model model) {
		User user = userRepository.findByPasswordResetToken(token).orElse(null);
		if (user != null) {
			model.addAttribute("token", token);
			return "reset-password-form";
		}
		return "error-page";
	}

	@PostMapping("/reset-password")
	public String handleResetPassword(@RequestParam("token") String token,
			@RequestParam("newPassword") String newPassword, RedirectAttributes redirAttrs) {
		Optional<User> optionalUser = userRepository.findByPasswordResetToken(token);

		if (optionalUser.isEmpty()) {
			redirAttrs.addFlashAttribute("message", new MessagePopup("Invalid or expired reset token", "alert-danger"));
			return "error-page";
		}

		User user = optionalUser.get();
		user.setPassword(passwordEncoder.encode(newPassword));
		user.setPasswordResetToken(null);
		userRepository.save(user);

		redirAttrs.addFlashAttribute("message",
				new MessagePopup("Password has been reset successfully", "alert-success"));
		return "redirect:/auth/reset/success";
	}

	@GetMapping("/reset/success")
	public String resetPasswordSuccess() {
		return "reset-password-success";
	}
}
