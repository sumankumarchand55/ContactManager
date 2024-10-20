package com.smart.contact.forms;

import org.springframework.web.multipart.MultipartFile;

import com.smart.contact.validators.ValidFile;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ContactForm {
    @NotBlank(message = "First Name is required!!!")
    @Size(min = 2, max = 15, message = "min 2 and max 15 characters are allowed!!!")
    private String firstName;

    @NotBlank(message = "Last Name is required!!!")
    @Size(min = 2, max = 10, message = "min 2 and max 10 characters are allowed!!!")
    private String lastName;

    @NotBlank(message = "")
    @Size(min = 2, max = 30, message = "min 2 and max 30 characters are allowed!!!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "invalid email address")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits long, Ex-1234567890")
    @NotBlank(message = "Phone number is required!!!")
    private String phone;

    @ValidFile(message = "Invalid File")
    private MultipartFile contactImage;

    private String image;

    private boolean favorite = false;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public MultipartFile getContactImage() {
		return contactImage;
	}

	public void setContactImage(MultipartFile contactImage) {
		this.contactImage = contactImage;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
