package com.smart.contact.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.contact.helper.AppConstants;
import com.smart.contact.helper.Helper;
import com.smart.contact.helper.ResourceNotFoundException;
import com.smart.contact.model.User;
import com.smart.contact.repository.UserRepository;
import com.smart.contact.service.EmailService;
import com.smart.contact.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Helper helper;

	@Autowired
	private UserRepository userRepository;

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EmailService emailService;

	@Override
	public User saveUser(User user) {
		UUID userId=UUID.randomUUID();
		user.setGeneratedUserId(userId);
		user.setEnabled(false);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoleList(List.of(AppConstants.ROLE_USER));
		user.setAbout("This account is creatted by User by Register.....");
		user.setPhoneNumber("1234567890");
		logger.info(user.getProvider().toString());
		String emailToken=UUID.randomUUID().toString();
		user.setEmailToken(emailToken);
		User savedUser=userRepository.save(user);
		String emailLink=helper.getLinkForEmailVeryfication(emailToken);
		emailService.sendEmail(savedUser.getEmail(),"Verify Account : Click on Veryfication Link to Verify Email", emailLink);
		scheduleUnverifiedUserCleanup(savedUser.getId());
		return savedUser;
	} 
	
	 private void scheduleUnverifiedUserCleanup(int userId) {
	        taskScheduler.schedule(() -> {
	            User user = userRepository.findById(userId).orElse(null);
	            if (user != null && !user.isEmailVeryfied()) {
	                userRepository.delete(user);
	                logger.info("Deleted unverified user after 10 second: {}", user.getEmail());
	            }
	        },Instant.now().plus(300, ChronoUnit.SECONDS));
	    }
	  @Autowired
	    private TaskScheduler taskScheduler;
	
	 @Override
	    public void resendVerificationEmail(String email) {
	        User user = userRepository.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

	        if (!user.isEnabled()) {
	            String newEmailToken = UUID.randomUUID().toString();
	            user.setEmailToken(newEmailToken);
	            userRepository.save(user);

	            String emailLink = helper.getLinkForEmailVeryfication(newEmailToken);
	            emailService.sendEmail(user.getEmail(), "Verify Account : Click on Verification Link to Verify Email", emailLink);
	        }
	    }

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User updateUser(int id,User user) {
		User existingUser=userRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("user not found"));
		 if (existingUser!= null) {
		 existingUser.setName(user.getName());
		 existingUser.setEmail(user.getEmail());
		 existingUser.setAbout(user.getAbout());
		 existingUser.setPhoneNumber(user.getPhoneNumber());
		 existingUser.setDob(user.getDob());
		 existingUser.setImageUrl(user.getImageUrl());
		return userRepository.save(existingUser);
	}
		    return null;
    }
	
	@Override
	public void changePassword(int id, String newPassword) {
	    User existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

	    String encodedPassword = passwordEncoder.encode(newPassword);
	    existingUser.setPassword(encodedPassword);

	    userRepository.save(existingUser);
	}

	@Override
	public void sendPasswordResetEmail(String email) {
	    User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

	    String resetToken = UUID.randomUUID().toString();
	    user.setPasswordResetToken(resetToken);
	    userRepository.save(user);

	    String resetLink = helper.getLinkForPasswordReset(resetToken);
	    emailService.sendEmail(user.getEmail(), "Reset Password: Click on the link to reset your password", resetLink);
	}

	
	

	@Override
	public void deleteUser(int id) {
		User user2=userRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("user not found"));
		    userRepository.delete(user2);
	}

	@Override
	public boolean isUserExist(int generatedUserId) {
       User user2=userRepository.findById(generatedUserId).orElse(null);
		return user2!=null?true:false;
	}

	@Override
	public boolean isUserExistByEmail(String email) {
		User user2=userRepository.findByEmail(email).orElse(null);
		return user2!=null?true:false;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {

		return userRepository.findByEmail(email).orElseThrow(null);
	}

	@Override
	public User disableUser(int id) {
		User user3=userRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("user not found"));
		 if (user3!= null) {
		   user3.setEmailVeryfied(false);
		   user3.setEnabled(false);
		  return userRepository.save(user3);
	}
		return user3;
	}
}
