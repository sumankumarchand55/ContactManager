package com.smart.contact.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smart.contact.repository.UserRepository;

@Service
public class SecurityCustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    return userRepository.findByEmail(username)
	        .orElseThrow(()
	        		-> new UsernameNotFoundException("User naot found with email:"+username));
	}


}
