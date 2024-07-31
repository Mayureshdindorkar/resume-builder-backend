package com.resume_builder_backend.resume_builder.service;

import java.util.List;

import com.resume_builder_backend.resume_builder.model.EducationDetails;
import com.resume_builder_backend.resume_builder.model.ExperienceDetails;
import com.resume_builder_backend.resume_builder.model.PersonalDetails;
import com.resume_builder_backend.resume_builder.model.ProjectDetails;
import com.resume_builder_backend.resume_builder.model.User;

public interface ResumService {
	
	public User savePersonalDetails(String username, PersonalDetails personalDetails);

	public User saveEducationDetails(String username, List<EducationDetails> educationDetails);

	public User saveExperienceDetails(String username, List<ExperienceDetails> experienceDetails);

	public User saveProjects(String username, List<ProjectDetails> projects);

	public User saveSkills(String username, List<String> skills);
	
}
