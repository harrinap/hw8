import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


public class Model {

	private int selectedStudent; //index for which student is selected in StudentView
	private int selectedCourse;//index for which course is selected in CourseView
	private List<ModelObserver> modelObservers; //controllers
	private List<Course> courses = new ArrayList<Course>();
	private List<Student> students = new ArrayList<Student>();
	
	private DefaultTableModel studentTableModel, courseTableModel, enrollmentTableModel;
	
	public int getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(int selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public void setSelectedCourse(int selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public Model(){		
		studentTableModel = new DefaultTableModel();
		courseTableModel = new DefaultTableModel();
		enrollmentTableModel = new DefaultTableModel();
		modelObservers = new ArrayList<ModelObserver>();
		initCourses();
		initStudents();
		selectedCourse = 0;
		selectedStudent = 0;		
		updateEnrollmentModel();
		
	}
	
	public void dropSelectedCourse(){
		students.get(selectedStudent).dropCourse(selectedCourse);
		updateEnrollmentModel();
	}

	private void initStudents() {
		
		Student joe = new Student(
				"Joe", 2012	);
		joe.addCourse(courses.get(courses.size()));
		joe.addCourse(courses.get(0));
		

		
		Student steve = new Student(
				"Steve", 2013);
		steve.addCourse(courses.get(2));
	
		Student kelsey = new Student(
				"Kelsey",
				2012);	
		kelsey.addCourse(courses.get(1));
		
		updateStudentModel();	
		notifyObservers();
	}
	
	private void notifyObservers(){
		for(ModelObserver m: modelObservers){
			m.updateFromModel();
		}
	}

	private void updateStudentModel() {
		studentTableModel.setRowCount(0);
		Vector<String>v;
		Student s;
		for(int i = 0; i<students.size(); i++)
		{
			v = new Vector<String>();
			s = students.get(i);
			v.add(Integer.toString(i));
			v.add(s.getName());
			v.add(Integer.toString(s.getGradyear()));
			studentTableModel.addRow(v);
		}
		
	}

	private void initCourses() {
		courses.add(new Course("CS101", "intro to CS"));
		courses.add(new Course("CS255", "hacking to do evil"));
		courses.add(new Course("SC002", "anthropology"));
		updateCourseModel();
		
	}

	private void updateCourseModel() {
		courseTableModel.setRowCount(0);
		Vector<String>v;
		Course s;
		for(int i = 0; i<courses.size(); i++)
		{
			s = courses.get(i);
			v = new Vector<String>();
		
			v.add(s.getCode());
			v.add(s.getTitle());
			studentTableModel.addRow(v);
		}
		
	}

	public void addObserver(ModelObserver m){
		this.modelObservers.add(m);
	}
	
	public void addStudent(Student s){
		students.add(s);
		updateStudentModel();
	}
	
	private void updateEnrollmentModel(){
		Student s = students.get(selectedStudent);
		List<Course> l = s.getCourses();
		enrollmentTableModel.setRowCount(0);
		Vector<String> v;
		for(Course c: l){
			v = new Vector<String>();
			v.add(c.getCode());
			v.add(c.getTitle());
			enrollmentTableModel.addRow(v);
		}
		
	}

	public DefaultTableModel getStudentTableModel() {
		return studentTableModel;
	}

	public DefaultTableModel getCourseTableModel() {
		return courseTableModel;
	}

	public DefaultTableModel getEnrollmentTableModel() {
		return enrollmentTableModel;
	}
	

	
	

	
	


}




