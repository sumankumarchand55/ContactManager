package com.smart.contact.config;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.smart.contact.helper.AppConstants;
import com.smart.contact.model.Providers;
import com.smart.contact.model.User;
import com.smart.contact.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	private UserRepository userRepository;

	Logger logger=LoggerFactory.getLogger(OAuthAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		 //before redirect here we save data in data base first
           logger.info("OAuthAuthenticationSuccessHandler");
           DefaultOAuth2User user=(DefaultOAuth2User)authentication.getPrincipal();
			/*
			 * logger.info(user.getName()); user.getAttributes().forEach((key,value)->{
			 *
			 * logger.info("{}=>{}",key,value); });
			 * logger.info(user.getAuthorities().toString());
			 */
          String email=user.getAttribute("email").toString();
          String name=user.getAttribute("name").toString();
          String picture=user.getAttribute("picture").toString();

          //create user and save in data base
          User user1=new User();
          user1.setEmail(email);
          user1.setName(name);
          user1.setImageUrl(picture);
          user1.setPassword("password");
          user1.setGeneratedUserId(UUID.randomUUID());
          user1.setProvider(Providers.GOOGLE);
          user1.setEnabled(true);
          user1.setEmailVeryfied(true);
          user1.setAgreed(true);
          user1.setPhoneNumber("1234567890");
          user1.setProviderUserId(user.getName());
          user1.setRoleList(List.of(AppConstants.ROLE_USER));
          user1.setAbout("This account is creatted by using google Auth.....");

          User user2=userRepository.findByEmail(email).orElse(null);
          if(user2==null) {
        	  userRepository.save(user1);
        	  logger.info("User Saved:  "+email);
          }

			new DefaultRedirectStrategy().sendRedirect(request, response, "/user/index");
		}

}
