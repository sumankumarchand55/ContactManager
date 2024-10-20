package com.smart.contact.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.smart.contact.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender eMailSender;
	
	@Value("${spring.mail.from}")
	private String domainName;

	@Override
	public void sendEmail(String to, String subject, String body) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject(subject);
			message.setText(body);
			message.setFrom(domainName);
			eMailSender.send(message);
			System.out.println("Email send successfully");
		} catch (Exception e) {
			System.out.println("Error in sending email!!!  "+e.getMessage());
		}
	}

	@Override
	public void sendEmailWithHtml() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailWithAttachment() {
		// TODO Auto-generated method stub
		
	}

}
