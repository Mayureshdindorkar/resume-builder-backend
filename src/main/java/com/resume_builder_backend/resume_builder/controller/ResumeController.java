package com.resume_builder_backend.resume_builder.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resume_builder_backend.resume_builder.model.EducationDetails;
import com.resume_builder_backend.resume_builder.model.ExperienceDetails;
import com.resume_builder_backend.resume_builder.model.PersonalDetails;
import com.resume_builder_backend.resume_builder.model.ProjectDetails;
import com.resume_builder_backend.resume_builder.model.User;
import com.resume_builder_backend.resume_builder.service.ResumService;

@RestController
@RequestMapping("/create-resume")
//@CrossOrigin(origins = "http://localhost:3000")
public class ResumeController {

	Logger logger = LoggerFactory.getLogger(ResumeController.class);

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private ResumService resumService;

	@PatchMapping("/personal-details")
	public ResponseEntity<?> savePersonalDetails(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		try
		{
			String username = payload.get("username").asText();
			JsonNode personalDetailState = payload.get("personalDetailState");
			PersonalDetails personalDetails = objectMapper.treeToValue(personalDetailState, PersonalDetails.class);
			
			User user = resumService.savePersonalDetails(username, personalDetails);
			if(user == null) return ResponseEntity.status(404).body("User not found!");
			
			return ResponseEntity.ok("Personal details saved successfully.");
		
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error processing request.");
		}
	}
	
	@PatchMapping("/education-details")
	public ResponseEntity<?> saveEducationDetails(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		try
		{
			String username = payload.get("username").asText();
			
			JsonNode educationDetailState = payload.get("educationDetailState");
	        List<EducationDetails> educationDetails = objectMapper.readValue(
	        		educationDetailState.toString(),
	            new TypeReference<List<EducationDetails>>() {}
	        );
	        
			User user = resumService.saveEducationDetails(username, educationDetails);
			if(user == null) return ResponseEntity.status(404).body("User not found!");
			
			return ResponseEntity.ok("Education details saved successfully.");
		
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error processing request.");
		}
	}
	
	@PatchMapping("/experience-details")
	public ResponseEntity<?> saveExperienceDetails(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		try
		{
			String username = payload.get("username").asText();
			
			JsonNode experienceDetailState = payload.get("experienceDetailState");
	        List<ExperienceDetails> experienceDetails = objectMapper.readValue(
	        		experienceDetailState.toString(),
	            new TypeReference<List<ExperienceDetails>>() {}
	        );
	        
			User user = resumService.saveExperienceDetails(username, experienceDetails);
			if(user == null) return ResponseEntity.status(404).body("User not found!");
			
			return ResponseEntity.ok("Experience details saved successfully.");
		
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error processing request.");
		}
	}
	
	@PatchMapping("/projects")
	public ResponseEntity<?> saveProjects(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		try
		{
			String username = payload.get("username").asText();
			
			JsonNode projectsState = payload.get("projectsState");
	        List<ProjectDetails> projects = objectMapper.readValue(
	        		projectsState.toString(),
	            new TypeReference<List<ProjectDetails>>() {}
	        );
	        
			User user = resumService.saveProjects(username, projects);
			if(user == null) return ResponseEntity.status(404).body("User not found!");
			
			return ResponseEntity.ok("Projects saved successfully.");
		
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error processing request.");
		}
	}
	
	@PatchMapping("/skills")
	public ResponseEntity<?> saveSkills(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
		try
		{
			String username = payload.get("username").asText();
			
			JsonNode skillsState = payload.get("skillsState");
	        List<String> skills = objectMapper.readValue(
	        		skillsState.toString(),
	            new TypeReference<List<String>>() {}
	        );
	        
			User user = resumService.saveSkills(username, skills);
			if(user == null) return ResponseEntity.status(404).body("User not found!");
			
			return ResponseEntity.ok("Skills saved successfully.");
		
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error processing request.");
		}
	}
}
