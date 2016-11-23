package entidades;

import java.util.ArrayList;

public class degreeCourse {
	private int code;
	private String title;
	private int yearsCourse;
	private ArrayList<Subject> subjects; 
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYearsCourse() {
		return yearsCourse;
	}
	public void setYearsCourse(int yearsCourse) {
		this.yearsCourse = yearsCourse;
	}
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	

}
