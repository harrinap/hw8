package model;

import java.io.Serializable;
import java.util.List;

public class SaveObject implements Serializable {

	List<Course> courses;
	List<Student> students;
	int student_id, selectedStudent;

	public SaveObject(List<Course> courses, List<Student> students,
			int student_id, int selectedStudent) {
		this.courses = courses;
		this.students = students;
		this.student_id = student_id;
		this.selectedStudent = selectedStudent;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public List<Student> getStudents() {
		return students;
	}

	public int getStudent_id() {
		return student_id;
	}

	public int getSelectedStudent() {
		return selectedStudent;
	}

}
