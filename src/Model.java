import java.util.ArrayList;
import java.util.List;


public class Model {

	private List<Course> courses;
	private List<Student> students;
	private int selectedStudent; //index for which student is selected in StudentView
	private int selectedCourse;//index for which course is selected in CourseView

	
	public int getSelectedStudent() {
		return selectedStudent;
	}


	public void setSelectedStudent(int selectedStudent) {
		this.selectedStudent = selectedStudent;
	}


	public int getSelectedCourse() {
		return selectedCourse;
	}


	public void setSelectedCourse(int selectedCourse) {
		this.selectedCourse = selectedCourse;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public List<Student> getStudents() {
		return students;
	}


	public Model(){
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
		selectedCourse = 0;
		selectedStudent = 0;
		
	}
	
	
	public void addStudent(Student s){
		students.add(s);	
	}

	public void addCourse(Course c){
		courses.add(c);
	}
	
	


}




