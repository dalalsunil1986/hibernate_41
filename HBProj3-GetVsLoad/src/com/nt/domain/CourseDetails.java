package com.nt.domain;

import java.io.Serializable;

public final class CourseDetails implements Serializable,ICourseDetails {
	private int courseId;
	private String courseName;
	private int duration;
	private String faculty;
	private int fee;
	private boolean status;
	
	private CourseDetails() {
		System.out.println("CourseDetails.0-param constructor");
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	

}
