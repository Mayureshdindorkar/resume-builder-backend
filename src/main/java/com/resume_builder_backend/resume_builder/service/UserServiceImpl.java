package com.resume_builder_backend.resume_builder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.resume_builder_backend.resume_builder.DTO.UserDTO;
import com.resume_builder_backend.resume_builder.model.User;
import com.resume_builder_backend.resume_builder.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository repository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	@Override
	public User signUpUser(User user) {
		logger.debug("User signedUp in database");
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
	}
	
	@Override
	public User saveUser(User user) {
		logger.debug("User saved in database");
		return repository.save(user);
	}

	@Override
	public User getUser(String username) {
		return repository.findByUsername(username);
	}
}
