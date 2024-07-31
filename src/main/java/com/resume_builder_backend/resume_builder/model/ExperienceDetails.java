package com.resume_builder_backend.resume_builder.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExperienceDetails {
	
	private String organizationName;
	private String position;
	private String startDate;
	private String endDate;
	private String description;

	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ExperienceDetails [organizationName=" + organizationName + ", position=" + position + ", startDate="
				+ startDate + ", endDate=" + endDate + ", description=" + description + "]";
	}	
}
