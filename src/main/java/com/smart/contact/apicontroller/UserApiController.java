package com.smart.contact.apicontroller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smart.contact.forms.ChangePasswordForm;
import com.smart.contact.forms.UserUpdateForm;
import com.smart.contact.helper.ResourceNotFoundException;
import com.smart.contact.model.User;
import com.smart.contact.service.ImageService;
import com.smart.contact.service.UserService;

@RestController
@RequestMapping("/user")
public class UserApiController {
	@Autowired
	private UserService userService;

	@Autowired
	private ImageService imageService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/update/view/{id}")
    public UserUpdateForm updateUserFormView(@PathVariable int id) {
	User user= userService.getUserById(id);
	UserUpdateForm userUpdateForm=new UserUpdateForm();
	userUpdateForm.setName(user.getName());
	userUpdateForm.setEmail(user.getEmail());
	userUpdateForm.setPhoneNumber(user.getPhoneNumber());
	userUpdateForm.setImageUrl(user.getImageUrl());
	userUpdateForm.setDob(user.getDob());
	userUpdateForm.setAbout(user.getAbout());
	return userUpdateForm;
	}

	@PostMapping("/update/{id}")
	@ResponseBody
	public ResponseEntity<String> updateUser(@PathVariable int id,
	                                            @ModelAttribute UserUpdateForm userUpdateForm, MultipartFile userImage) {
	    try {
        // Fetch the existing user
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the non-file fields
        existingUser.setName(userUpdateForm.getName());
        existingUser.setEmail(userUpdateForm.getEmail());
        existingUser.setPhoneNumber(userUpdateForm.getPhoneNumber());
        existingUser.setAbout(userUpdateForm.getAbout());
        existingUser.setDob(userUpdateForm.getDob());

        // Handle file upload
        if (userUpdateForm.getUserImage()!=null && !userUpdateForm.getUserImage().isEmpty()) {

			  if (existingUser.getCloudinaryImagePublicId() != null) {
			  imageService.deleteImage(existingUser.getCloudinaryImagePublicId()); }

            // Upload new image
            String filename = UUID.randomUUID().toString();
            String fileUrl = imageService.uploadImage(userUpdateForm.getUserImage(), filename);

            // Set new image details
            existingUser.setImageUrl(fileUrl);
            existingUser.setCloudinaryImagePublicId(filename);
            System.out.print("filename"+fileUrl);
        }
        User updatedUser= userService.updateUser(id, existingUser);
        return ResponseEntity.ok("User updated successfully");

    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
    }
}
	
	@PostMapping("/change-password/{id}")
	@ResponseBody
	public ResponseEntity<String> changePassword(@PathVariable int id, 
	                                             @ModelAttribute ChangePasswordForm changePasswordForm) {
	    try {
	        User existingUser = userService.getUserById(id);

	        if (!passwordEncoder.matches(changePasswordForm.getCurrentPassword(), existingUser.getPassword())) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("password is incorrect");
	        }

	        if (!changePasswordForm.getNewPassword().equals(changePasswordForm.getConfirmPassword())) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("New password and confirm password do not match");
	        }

	        userService.changePassword(id, changePasswordForm.getNewPassword());

	        return ResponseEntity.ok("Password changed successfully");

	    } catch (ResourceNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}
}
