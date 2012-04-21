package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<ModelObserver> modelObservers = new ArrayList<ModelObserver>();
	private List<Course> courses = new ArrayList<Course>();
	private List<Student> students = new ArrayList<Student>();
	private int student_id = 0;
	private int selectedStudent = -1;

	public int getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(int selectedStudent) {
		this.selectedStudent = selectedStudent;
		notifyObservers();
	}

	public SaveObject getSaveObject() {
		return new SaveObject(courses, students, student_id, selectedStudent);
	}

	public Model(SaveObject saved) {
		this.courses = saved.getCourses();
		this.selectedStudent = saved.getSelectedStudent();
		this.student_id = saved.getStudent_id();
		this.students = saved.getStudents();
	}

	public Model() {
		// initCourses();
		// initStudents();

	}

	private void notifyObservers() {
		for (ModelObserver ob : modelObservers)
			ob.updateFromModel();
	}

	public void addObserver(ModelObserver m) {
		this.modelObservers.add(m);
	}

	public void addCourse(String code, String title) {
		String properCode = code.toLowerCase();
		// to prevent duplicates
		for (Course c : courses) {
			if (c.getCode().equals(properCode))
				return;
		}

		Course c = new Course(properCode, title);
		courses.add(c);
		notifyObservers();

	}

	public void addCourseToStudent(int courseIndex, int studentIndex) {

		// to prevent duplicates
		List<Course> currentCourses = getStudent(studentIndex).getCourses();
		String indexToAdd = courses.get(courseIndex).getCode();

		for (Course c : currentCourses) {
			if (indexToAdd.equals(c.getCode()))
				return;
		}

		students.get(studentIndex).addCourse(courses.get(courseIndex));
		notifyObservers();
	}

	public void addStudent(String name, int gradYear) {
		// to prevent duplicate students
		for (Student s : students)
			if (s.getName().toLowerCase().equals(name.toLowerCase())
					&& gradYear == s.getGradyear())
				return;

		if (selectedStudent == -1)
			selectedStudent = 0;

		students.add(new Student(student_id++, name, gradYear));
		notifyObservers();
	}

	public List<Course> getCourses() {
		return courses;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void dropCourse(int selectedCourse, int selectedStudent) {
		if (students.get(selectedStudent).getCourses().size() > 0) {
			students.get(selectedStudent).dropCourse(selectedCourse);
			notifyObservers();
		}

	}

	public Student getStudent(int index) {
		return students.get(index);
	}

}
