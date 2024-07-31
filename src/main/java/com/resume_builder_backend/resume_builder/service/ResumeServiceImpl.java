package com.resume_builder_backend.resume_builder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume_builder_backend.resume_builder.model.EducationDetails;
import com.resume_builder_backend.resume_builder.model.ExperienceDetails;
import com.resume_builder_backend.resume_builder.model.PersonalDetails;
import com.resume_builder_backend.resume_builder.model.ProjectDetails;
import com.resume_builder_backend.resume_builder.model.User;

@Service
public class ResumeServiceImpl implements ResumService {

	@Autowired
	private UserService userService;
	
	@Override
	public User savePersonalDetails(String username, PersonalDetails personalDetails) {
		
		User user = userService.getUser(username);
		if(user == null) return null;
		
		user.setPersonalDetails(personalDetails);
		return userService.saveUser(user);
	}

	@Override
	public User saveEducationDetails(String username, List<EducationDetails> educationDetails) {
		User user = userService.getUser(username);
		if(user == null) return null;
		
		user.setEducationDetails(educationDetails);
		return userService.saveUser(user);
	}

	@Override
	public User saveExperienceDetails(String username, List<ExperienceDetails> experienceDetails) {
		User user = userService.getUser(username);
		if(user == null) return null;
		
		user.setExperienceDetails(experienceDetails);
		return userService.saveUser(user);
	}

	@Override
	public User saveProjects(String username, List<ProjectDetails> projects) {
		User user = userService.getUser(username);
		if(user == null) return null;
		
		user.setProjectDetails(projects);
		return userService.saveUser(user);
	}

	@Override
	public User saveSkills(String username, List<String> skills) {
		User user = userService.getUser(username);
		if(user == null) return null;
		
		user.setSkills(skills);
		return userService.saveUser(user);
	}

}
