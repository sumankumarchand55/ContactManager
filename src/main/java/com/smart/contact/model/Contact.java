package com.smart.contact.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CONTACT")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "First Name is required!!!")
	@Size(min = 2, max = 15, message = "min 2 and max 15 characters are allowed!!!")
	private String firstName;
	@NotBlank(message = "Last Name is required!!!")
	@Size(min = 2, max = 10, message = "min 2 and max 10 characters are allowed!!!")
	private String lastName;
	@NotBlank(message = "Email is required!!!")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "invalid email address")
	private String email;
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits long, Ex-1234567890")
	@NotBlank(message = "Phone number is required!!!")
	private String phone;
	private String image;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	private boolean favorite = false;
	private String cloudinaryImagePublicId;

	public String getCloudinaryImagePublicId() {
		return cloudinaryImagePublicId;
	}

	public void setCloudinaryImagePublicId(String cloudinaryImagePublicId) {
		this.cloudinaryImagePublicId = cloudinaryImagePublicId;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@ManyToOne
	@JsonIgnore
	private User user;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
	    return "Contact [id=" + id +
	           ", firstName=" + firstName +
	           ", lastName=" + lastName +
	           ", email=" + email +
	           ", phone=" + phone +
	           ", image=" + image +
	           ", createdAt=" + createdAt +
	           ", updatedAt=" + updatedAt +
	           ", favorite=" + favorite +
	           ", cloudinaryImagePublicId=" + cloudinaryImagePublicId +
	           ", userId=" + (user != null ? user.getId() : "null") + "]";
	}

	 public String getFormattedCreatedAt() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, hh:mm:ss a");
	        return createdAt != null ? createdAt.format(formatter) : "";
	    }

	    // New method for formatted updatedAt
	    public String getFormattedUpdatedAt() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, hh:mm:ss a");
	        return updatedAt != null ? updatedAt.format(formatter) : "";
	    }
}
