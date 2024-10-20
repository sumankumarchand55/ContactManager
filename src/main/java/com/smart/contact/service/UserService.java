package com.smart.contact.service;

import java.util.List;

import com.smart.contact.model.User;

public interface UserService {

	User saveUser(User user);
    User getUserById(int id);
    User updateUser(int id,User user);
    void deleteUser(int id);
    boolean isUserExist(int generatedUserId);
    boolean isUserExistByEmail(String email);
    List<User> getAllUsers();
    User getUserByEmail(String email);
	void resendVerificationEmail(String email);
	User disableUser(int id);
	void changePassword(int id, String newPassword);
	void sendPasswordResetEmail(String email);
}
