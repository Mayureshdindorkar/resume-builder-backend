package com.resume_builder_backend.resume_builder.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.resume_builder_backend.resume_builder.model.User;
import com.resume_builder_backend.resume_builder.model.UserDetailsImpl;
import com.resume_builder_backend.resume_builder.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			logger.info("User '" + username + "' not found!");
			throw new UsernameNotFoundException("User '" + username + "' not found!");
		}
		return new UserDetailsImpl(user);
	}

}
