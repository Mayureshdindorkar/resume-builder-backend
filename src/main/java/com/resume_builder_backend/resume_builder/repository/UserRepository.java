package com.resume_builder_backend.resume_builder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.resume_builder_backend.resume_builder.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByUsername(String username);

}
