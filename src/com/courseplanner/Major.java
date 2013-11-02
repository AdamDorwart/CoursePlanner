package com.courseplanner;


public class Major {
	private String Name;
	private String Code;
	private String Description;
	private String[] ReqCourse;
	private String[] Elective;
	private String[] MiscElective;
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		this.Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public String[] getReqCourse() {
		return ReqCourse;
	}
	public void setReqCourse(String[] reqCourse) {
		this.ReqCourse = reqCourse;
	}
	public String[] getElective() {
		return Elective;
	}
	public void setElective(String[] elective) {
		this.Elective = elective;
	}
	public String[] getMiscElective() {
		return MiscElective;
	}
	public void setMiscElective(String[] miscElective) {
		this.MiscElective = miscElective;
	}
	
}
