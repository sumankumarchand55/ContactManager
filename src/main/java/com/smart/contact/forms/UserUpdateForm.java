package com.smart.contact.forms;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.smart.contact.validators.ValidFile;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserUpdateForm {
	    @NotBlank(message="Name is required!!!")
	    @Size(min=2,max=20,message="min 2 and max 20 characters are allowed!!!")
		private String name;
		@Column(unique = true)
		@Pattern(regexp="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",message="invalid email address")
		private String email;
		private String imageUrl;
		@Column(length = 500)
		@NotBlank(message="description is required!!!")
	    @Size(min=10,message="description contain minimum 10 characters!!!")
		private String about;
		private Date dob;
		@Pattern(regexp="^[0-9]{10}$", message="Phone number must be 10 digits long, Ex-1234567890")
		@NotBlank(message="Phone number is required!!!")
		private String phoneNumber;
		@ValidFile(message = "Invalid File")
		private MultipartFile userImage;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getAbout() {
			return about;
		}
		public void setAbout(String about) {
			this.about = about;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date date) {
			this.dob = date;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public MultipartFile getUserImage() {
			return userImage;
		}
		public void setUserImage(MultipartFile userImage) {
			this.userImage = userImage;
		}
}
