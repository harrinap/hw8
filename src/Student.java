import java.util.ArrayList;
import java.util.List;


public class Student {
	private int id, gradyear;
	private String name;
	private List<Course> courses;
	
	public Student(int id, int gradyear, String name){
		courses = new ArrayList<Course>();
		this. id = id; 
		this.gradyear = gradyear;
		this.name = name;
	}
	
	public void dropCourse(int index){
		courses.remove(index);
	}

	public void addCourse(Course c){
		courses.add(c);
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	
	
	public int getId() {
		return id;
	}

	public int getGradyear() {
		return gradyear;
	}

	public String getName() {
		return name;
	}

}
