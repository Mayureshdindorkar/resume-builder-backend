package com.resume_builder_backend.resume_builder.service;

import com.resume_builder_backend.resume_builder.model.User;

public interface UserService {

	public User signUpUser(User user);
	
	public User saveUser(User user);
	
	public User getUser(String username);
	
}
