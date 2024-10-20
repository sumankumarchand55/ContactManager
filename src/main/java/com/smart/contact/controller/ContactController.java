package com.smart.contact.controller;

import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.contact.config.OAuthAuthenticationSuccessHandler;
import com.smart.contact.forms.ContactForm;
import com.smart.contact.forms.ContactSearchForm;
import com.smart.contact.helper.Helper;
import com.smart.contact.helper.MessagePopup;
import com.smart.contact.model.Contact;
import com.smart.contact.model.User;
import com.smart.contact.service.ContactService;
import com.smart.contact.service.ImageService;
import com.smart.contact.service.UserService;

import jakarta.validation.Valid;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	@Autowired
	private UserService userService;
	@Autowired
	private ImageService imageService;

	Logger logger = LoggerFactory.getLogger(OAuthAuthenticationSuccessHandler.class);

	@GetMapping("/user/contacts/add")
	public String showAddContactForm(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "afterlogin/contacts/addcontact";
	}

	@PostMapping("/user/contacts/add")
	public String addContact(@Valid @ModelAttribute("contactForm") ContactForm contactForm, BindingResult result1,
			Model model, RedirectAttributes redirAttrs, Authentication authentication) {

		try {
			if (result1.hasErrors()) {
				result1.getAllErrors().forEach(error -> logger.info(error.toString()));
				model.addAttribute("contactForm", contactForm);
				return "/afterlogin/contacts/addcontact";
			}
			String filename = UUID.randomUUID().toString();
			String fileUrl = imageService.uploadImage(contactForm.getContactImage(), filename);

			String username = Helper.getEmailOfLoggedInUser(authentication);
			User user = userService.getUserByEmail(username);
			Contact contact = new Contact();
			contact.setUser(user);
			contact.setFirstName(contactForm.getFirstName());
			contact.setLastName(contactForm.getLastName());
			contact.setEmail(contactForm.getEmail());
			contact.setPhone(contactForm.getPhone());
			contact.setFavorite(contactForm.isFavorite());
			contact.setImage(fileUrl);
			contact.setCloudinaryImagePublicId(filename);
			// Save contact
			contactService.saveContact(contact);

			System.out.println(contactForm);
			redirAttrs.addFlashAttribute("message",
					new MessagePopup("New Contact Created Successfully", "alert-success"));
			return "redirect:/user/contacts";
		} catch (Exception e) {
			model.addAttribute("contact", contactForm);
			redirAttrs.addFlashAttribute("message", new MessagePopup("Error: " + e.getMessage(), "alert-danger"));
			return "redirect:/user/contacts/add";
		}
	}

	@GetMapping("/user/contacts")
	public String ViewContact(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "8") int size,
			@RequestParam(value = "sortBy", defaultValue = "createdAt") String sortBy, // asc for ascending and reverse
																						// desc
			@RequestParam(value = "direction", defaultValue = "desc") String direction, Model model,
			Authentication authentication) {

		String usernmae = Helper.getEmailOfLoggedInUser(authentication);
		User user = userService.getUserByEmail(usernmae);
		Page<Contact> pageContact = contactService.getByUser(user, page, size, sortBy, direction);
		pageContact.getContent();
		model.addAttribute("pageContact", pageContact);
		model.addAttribute("contactSearchForm", new ContactSearchForm());
		  List<Contact> allContacts = contactService.getAllContactsByUser(user);
		    model.addAttribute("allContacts", allContacts);
		return "afterlogin/contacts/viewcontacts";
	}

	@GetMapping("/user/contacts/favorites")
	public String viewFavoriteContacts(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "8") int size,
			@RequestParam(value = "sortBy", defaultValue = "createdAt") String sortBy,
			@RequestParam(value = "direction", defaultValue = "desc") String direction, Model model,
			Authentication authentication) {

		String username = Helper.getEmailOfLoggedInUser(authentication);
		User user = userService.getUserByEmail(username);

		// Fetch only favorite contacts
		Page<Contact> pageContact = contactService.getFavoriteContactsByUser(user, page, size, sortBy, direction);
		model.addAttribute("pageContact", pageContact);

		return "afterlogin/contacts/favorite";
	}

	@RequestMapping("/user/contacts/search")
	public String searchHandler(@ModelAttribute ContactSearchForm contactSearchForm,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "50") int size,
			@RequestParam(value = "sortBy", defaultValue = "firstName") String sortBy,
			@RequestParam(value = "direction", defaultValue = "asc") String direction, Model model,
			Authentication authentication) {
		String username = Helper.getEmailOfLoggedInUser(authentication);
		User user = userService.getUserByEmail(username);
		String keyword = contactSearchForm.getKeyword() != null ? contactSearchForm.getKeyword().trim() : "";
		if (keyword.isEmpty()) {
			model.addAttribute("errorMessage", "No results found. Please enter a valid keyword.");
			model.addAttribute("pageContact", Page.empty());
			return "afterlogin/contacts/search";
		}

		contactSearchForm.setKeyword(keyword);
		logger.info("Searching field: {} with keyword: {}", contactSearchForm.getField(), keyword);

		Page<Contact> pageContact = Page.empty();
		switch (contactSearchForm.getField().toLowerCase()) {
		case "firstname":
			pageContact = contactService.searchByFirstName(user, keyword, size, page, sortBy, direction);
			break;
		case "lastname":
			pageContact = contactService.searchByLastName(user, keyword, size, page, sortBy, direction);
			break;
		case "phone":
			pageContact = contactService.searchByPhoneNumber(user, keyword, size, page, sortBy, direction);
			break;
		case "email":
			pageContact = contactService.searchByEmail(user, keyword, size, page, sortBy, direction);
			break;
		default:
			model.addAttribute("errorMessage", "Invalid search field.");
			return "afterlogin/contacts/search";
		}

		if (pageContact.isEmpty()) {
			model.addAttribute("errorMessage", "No results found for your search.");
		}

		model.addAttribute("pageContact", pageContact);
		model.addAttribute("contactSearchForm", contactSearchForm);
		return "afterlogin/contacts/search";
	}

	@DeleteMapping("/user/contacts/delete/{id}")
	public String deleteConact(@PathVariable int id) {
		Contact contact = contactService.getContactById(id);
		if (contact.getCloudinaryImagePublicId() != null) {
			imageService.deleteImage(contact.getCloudinaryImagePublicId());
		}
		contactService.deleteContact(id);
		logger.info("id {} deleted", id);
		return "redirect:/user/contacts";
	}	
}
