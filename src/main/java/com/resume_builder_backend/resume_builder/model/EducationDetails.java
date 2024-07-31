package com.resume_builder_backend.resume_builder.model;

public class EducationDetails {

	private String schoolName;
	private Integer passingYear;
	private String degreeTitle;
	private String grade;
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Integer getPassingYear() {
		return passingYear;
	}
	public void setPassingYear(Integer passingYear) {
		this.passingYear = passingYear;
	}
	public String getDegreeTitle() {
		return degreeTitle;
	}
	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "EducationDetails [schoolName=" + schoolName + ", passingYear=" + passingYear + ", degreeTitle="
				+ degreeTitle + ", grade=" + grade + "]";
	}
}
