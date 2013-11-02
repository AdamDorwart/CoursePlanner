package com.courseplanner;

public class Course {

	private String id = null;
	private String name = null;
	private String units = null;
	private String description = null;
	private String prerequisites = "none";

	public Course() {

	}

	public void setID(String input) {
		this.id = input;
	}

	public void setName(String input) {
		this.name = input;
	}

	public void setUnits(String input) {
		this.units = input;
	}

	public void setDescription(String input) {
		this.description = input;
	}

	public void setPrerequisites(String input) {
		this.prerequisites = input;
	}

	public String getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getUnits() {
		return this.units;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPrerequisites() {
		return this.prerequisites;
	}
}
