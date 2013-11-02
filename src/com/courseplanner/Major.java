package com.courseplanner;

public class Major {
	private String name;
	private String code;
	private String description;
	private String[] reqCourse;
	private String[] elective;
	private String[] miscElective;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getReqCourse() {
		return reqCourse;
	}
	public void setReqCourse(String[] reqCourse) {
		this.reqCourse = reqCourse;
	}
	public String[] getElective() {
		return elective;
	}
	public void setElective(String[] elective) {
		this.elective = elective;
	}
	public String[] getMiscElective() {
		return miscElective;
	}
	public void setMiscElective(String[] miscElective) {
		this.miscElective = miscElective;
	}
	
}
