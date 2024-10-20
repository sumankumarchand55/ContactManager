package com.smart.contact.apicontroller;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smart.contact.forms.ContactForm;
import com.smart.contact.model.Contact;
import com.smart.contact.service.ContactService;
import com.smart.contact.service.ImageService;

@RestController
@RequestMapping("/user")
public class ContactApiController {
	@Autowired
	 private ContactService contactService;
	@Autowired
	private ImageService imageService;

	@GetMapping("/contacts/view/{id}")
	public Contact getContact(@PathVariable int id) {
		return contactService.getContactById(id);
	}

	@GetMapping("/contacts/update/view/{id}")
	    public ContactForm updateContactFormView(@PathVariable int id) {
		Contact contact= contactService.getContactById(id);
		ContactForm contactForm=new ContactForm();
		contactForm.setFirstName(contact.getFirstName());
		contactForm.setLastName(contact.getLastName());
		contactForm.setEmail(contact.getEmail());
		contactForm.setPhone(contact.getPhone());
		contactForm.setFavorite(contact.isFavorite());
		contactForm.setImage(contact.getImage());
		return contactForm;
		}

		@PostMapping("/contacts/update/{id}")
		@ResponseBody
		public ResponseEntity<String> updateContact(@PathVariable int id,
		                                            @ModelAttribute ContactForm contactForm, MultipartFile contactImage) {
		    try {
	        // Fetch the existing contact
	        Contact existingContact = contactService.getContactById(id);

	        if (existingContact == null) {
	            return ResponseEntity.notFound().build();
	        }

	        // Update the non-file fields
	        existingContact.setFirstName(contactForm.getFirstName());
	        existingContact.setLastName(contactForm.getLastName());
	        existingContact.setEmail(contactForm.getEmail());
	        existingContact.setPhone(contactForm.getPhone());
	        existingContact.setFavorite(contactForm.isFavorite());

	        // Handle file upload
	        if (contactForm.getContactImage()!=null && !contactForm.getContactImage().isEmpty()) {

				  if (existingContact.getCloudinaryImagePublicId() != null) {
				  imageService.deleteImage(existingContact.getCloudinaryImagePublicId()); }

	            // Upload new image
	            String filename = UUID.randomUUID().toString();
	            String fileUrl = imageService.uploadImage(contactForm.getContactImage(), filename);

	            // Set new image details
	            existingContact.setImage(fileUrl);
	            existingContact.setCloudinaryImagePublicId(filename);
	            System.out.print("filename"+fileUrl);
	        }
	        Contact updatedContact = contactService.updateContact(id, existingContact);
	        return ResponseEntity.ok("Contact updated successfully");

	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}

}
