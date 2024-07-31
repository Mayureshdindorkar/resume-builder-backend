package com.resume_builder_backend.resume_builder.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resume_builder_backend.resume_builder.DTO.UserDTO;
import com.resume_builder_backend.resume_builder.model.User;
import com.resume_builder_backend.resume_builder.security.JWTService;
import com.resume_builder_backend.resume_builder.service.UserService;

// We can also assign @RequestMapping("uri") for controller class
@RestController
//@CrossOrigin(origins = "http://localhost:3000") // because React app is running on port 3000 // To avoid CORS error // Just writing @CrossOrigin will make the apis public to all users
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired		
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTService jwtService;
	
	@PostMapping("/auth/signup")
	public ResponseEntity<Map<String, String>> saveUser(@RequestBody UserDTO userDTO) {
		
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		
		User savedUser = userService.signUpUser(user);
		logger.debug("Inside controller: " + savedUser);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", savedUser.getUsername());
		map.put("message", "SignUp Sucessful for user '" + savedUser.getUsername() + "'");
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
		logger.debug("Inside controller");
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(authentication.isAuthenticated()) {
			String token = jwtService.generateToken(userDTO.getUsername());
			map.put("token", token);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("message", "Login Failed!");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/getUser/{username}")
	public ResponseEntity<?> getUserState(@PathVariable String username) {
		User user = userService.getUser(username);
		
		if(user == null) return ResponseEntity.status(404).body("User not found!");
		
		user.setPassword(null);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
