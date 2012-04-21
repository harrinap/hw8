import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Model;
import model.SaveObject;
import view.CourseView;
import view.EnrollmentView;
import view.SaveView;
import view.StudentView;
import controller.CourseController;
import controller.EnrollmentController;
import controller.SaveController;
import controller.StudentController;

public class CourseRegistration {

	public static void main(String args[]) throws IOException,
			ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		
		
		Model m = initModel();

		StudentView studentView = new StudentView();
		StudentController s = new StudentController(m, studentView);
		CourseView c = new CourseView();
		CourseController cc = new CourseController(m, c);
		EnrollmentView e = new EnrollmentView();
		EnrollmentController econtroler = new EnrollmentController(m, e, s, cc);
		SaveView saveView = new SaveView();
		SaveController saveC = new SaveController(m, saveView);

	}

	private static Model initModel() throws IOException, ClassNotFoundException {
		
		
		File f = new File("model.ser");

		if (f.exists()) {
			FileInputStream is = new FileInputStream(f);
			ObjectInputStream input = new ObjectInputStream(is);
			SaveObject saved = (SaveObject) input.readObject();
			input.close();
			return new Model(saved);

		} else
			return new Model();

	}

}
