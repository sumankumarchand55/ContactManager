package com.smart.contact.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class Helper {
	
	 @Value("${server.baseUrl}")
	    private String baseUrl;

    public static String getEmailOfLoggedInUser(Authentication authentication) {
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            String clientId = oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

        	var oauth2User=(OAuth2User)authentication.getPrincipal();
        	String username="";

            //  find user name in case of google login
            if (clientId.equalsIgnoreCase("google")) {
                System.out.println("Getting email from Google");
               username= oauth2User.getAttribute("email").toString();
                return oAuth2AuthenticationToken.getPrincipal().getAttribute("email");
            }
            return username;
        } else {
            System.out.println("Getting Email From LocalDB");
            return authentication.getName();
        }
    }


   public  String getLinkForEmailVeryfication( String emailToken) {
	   return this.baseUrl + "/auth/verify-email?token="+emailToken;
   }
   
   public  String getLinkForPasswordReset(String resetToken) {
	   return this.baseUrl + "/auth/reset-password?token=" + resetToken;
	}
   
}