import model.Model;
import view.CourseView;
import view.EnrollmentView;
import view.StudentView;
import controller.CourseController;
import controller.EnrollmentController;
import controller.StudentController;


public class test {

	public static void main (String args[]){
		Model m = new Model();
		StudentView studentView = new StudentView();
		StudentController s = new StudentController(m, studentView);
		//EnrollmentView e = new EnrollmentView();
		//EnrollmentController econtroler = new EnrollmentController(m, e);
		CourseView c = new CourseView();
		CourseController cc= new CourseController(m, c);
		
	}
	
}
