package com.smart.contact.forms;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public class ChangePasswordForm {

	@Size(min = 8, message = "length should min 8 characters!!!")
	@Column(nullable = false)
	private String currentPassword;
	@Size(min = 8, message = "length should min 8 characters!!!")
	@Column(nullable = false)
	private String newPassword;
	@Size(min = 8, message = "length should min 8 characters!!!")
	@Column(nullable = false)
	private String confirmPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
