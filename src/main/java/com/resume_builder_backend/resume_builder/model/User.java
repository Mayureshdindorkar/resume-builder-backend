package com.resume_builder_backend.resume_builder.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collection = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@Id
	private String username;
	private String password;
	private PersonalDetails personalDetails;
	private List<EducationDetails> educationDetails;
	private List<ExperienceDetails> experienceDetails;
	private List<ProjectDetails> projectDetails;
	private List<String> skills;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public List<EducationDetails> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(List<EducationDetails> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public List<ExperienceDetails> getExperienceDetails() {
		return experienceDetails;
	}

	public void setExperienceDetails(List<ExperienceDetails> experienceDetails) {
		this.experienceDetails = experienceDetails;
	}

	public List<ProjectDetails> getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(List<ProjectDetails> projectDetails) {
		this.projectDetails = projectDetails;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", personalDetails=" + personalDetails
				+ ", educationDetails=" + educationDetails + ", experienceDetails=" + experienceDetails
				+ ", projectDetails=" + projectDetails + ", skills=" + skills + "]";
	}
}
