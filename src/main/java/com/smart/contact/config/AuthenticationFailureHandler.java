package com.smart.contact.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.smart.contact.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        if (exception instanceof DisabledException) {
            String email = request.getParameter("email");
            try {
                UserService userService = applicationContext.getBean(UserService.class);
                userService.resendVerificationEmail(email);
                response.sendRedirect("/login?error=disabled&emailSent=true");
            } catch (UsernameNotFoundException e) {
                response.sendRedirect("/login?error=invalid");
            }
        } else {
            response.sendRedirect("/login?error=invalid");
        }
    }
}