import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class CourseView extends JFrame {

	JPanel panel;
	CourseController courseController;

	public CourseView(CourseController courseController) {
		this.courseController = courseController;
		setTitle("Course Info");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocation(200,200);
	  	setSize(20,20);
	    panel = new CoursePanel(this);
	    setContentPane(panel);
	    pack();
	    setVisible(true);		
	}
	
	private class CoursePanel extends JPanel{
		CourseView courseView;
		JButton newCourse;
		JTextField code, title;
		JPanel courseTable;
		String[] headers = {"Code", 
				"Title"
		};
		public CoursePanel(CourseView courseView) {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			newCourse = new JButton("New Course");
			code = new JTextField(10);
			title = new JTextField(10);
			this.courseView = courseView;
			courseTable = new MyTable(headers);
			add(courseTable);
			add(title);
			add(code);
			add(newCourse);
			
		}

	
		
	
	

	}}
