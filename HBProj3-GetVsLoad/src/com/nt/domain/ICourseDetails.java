package com.nt.domain;

public interface ICourseDetails {
	public  int getCourseId();
	public void setCourseId(int courseId);
	public String getCourseName();
	public void setCourseName(String courseName);
	public String getFaculty();
	public void setFaculty(String faculty);
	public void setDuration(int duration);
	public int getDuration();
	public void setFee(int fee);
	public int getFee();
	public void setStatus(boolean status);
	public boolean isStatus();
}
