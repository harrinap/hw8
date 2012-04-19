package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private static int id = -1;
	private int gradyear;
	private String name;
	private List<Course> courses;

	public Student(String name, int gradyear) {
		id++;
		courses = new ArrayList<Course>();

		this.gradyear = gradyear;
		this.name = name;
	}

	public void dropCourse(int index) {
		courses.remove(index);
	}

	public void addCourse(Course c) {
		courses.add(c);
	}
	
	public int getId(){
		return id;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public int getGradyear() {
		return gradyear;
	}

	public String getName() {
		return name;
	}

}