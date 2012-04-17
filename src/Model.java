import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Model {

	private int selectedStudent; //index for which student is selected in StudentView
	private int selectedCourse;//index for which course is selected in CourseView
	private List<ModelObserver> modelObservers; //controllers
	private List<Course> courses = new ArrayList<Course>();
	private List<Student> students = new ArrayList<Student>();
	
	
	private int selectedEnrollment;
	private StudentController studentController;
	private EnrollmentController enrollmentController;
	
	
	public Model(){		

		modelObservers = new ArrayList<ModelObserver>();
		initCourses();
		initStudents();
		selectedCourse = 0;
		selectedStudent = 0;		
		
		
		
	}

	public int getSelectedStudent() {
		return selectedStudent;
		
	}
	
	public void addStudentController(StudentController s){
		this.studentController= s;
	}
	
	public void addEnrollmentController(EnrollmentController e){
		this.enrollmentController = e;
	}

	public void setSelectedStudent(int selectedStudent) {
		if(this.selectedStudent!= selectedStudent){
			this.selectedStudent = selectedStudent;
		
			notifyObservers();
		}
	}

	public void setSelectedCourse(int selectedCourse) {
		this.selectedCourse = selectedCourse;
		notifyObservers();
	}

	public void dropSelectedCourse(){
		students.get(selectedStudent).dropCourse(selectedCourse);
		
	}

	private void initStudents() {
		
		Student joe = new Student(
				"Joe", 2012	);
		joe.addCourse(courses.get(courses.size()-1));
		joe.addCourse(courses.get(0));
		students.add(joe);
		

		
		Student steve = new Student(
				"Steve", 2013);
		steve.addCourse(courses.get(2));
		students.add(steve);
	
		Student kelsey = new Student(
				"Kelsey",
				2012);	
		kelsey.addCourse(courses.get(1));
		students.add(kelsey);
		

		
	}
	
	private void notifyObservers(){
		studentController.updateFromModel();
		//enrollmentController.updateFromModel();
	}

	private void initCourses() {
		courses.add(new Course("CS101", "intro to CS"));
		courses.add(new Course("CS255", "hacking to do evil"));
		courses.add(new Course("SC002", "anthropology"));
		
		
	}

	public void addObserver(ModelObserver m){
		this.modelObservers.add(m);
	}
	
	public void addStudent(Student s){
		students.add(s);
		notifyObservers();
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setSelectedEnrollment(int rowIndex) {
		this.selectedEnrollment = rowIndex;
		
	}

	public void dropCourse() {
		students.get(selectedStudent).dropCourse(selectedCourse);
		notifyObservers();
		
	}

	public void addCourse() {
		students.get(selectedStudent).dropCourse(selectedCourse);
		notifyObservers();
		
	}

	public void selectStudent(int selectedStudent2) {
		// TODO Auto-generated method stub
		
	}
	

	
	

	
	


}




