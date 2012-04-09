import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class EnrollmentView extends JFrame {
	JPanel panel;
	EnrollmentController enrollmentController;

	public EnrollmentView(EnrollmentController enrollmentController) {
		this.enrollmentController = enrollmentController;
		setTitle("Enrollment Info");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocation(200,200);
	  	setSize(20,200);
	    panel = new EnrollmentPanel(this);
	    setContentPane(panel);
	    pack();
	    setVisible(true);
		
	}
	
	private class EnrollmentPanel extends JPanel{
		
		
		JButton selectStudent, add, drop;
	
		JPanel enrollmentTable;
		
		String[] headers = {"Code", "Title"};

		public EnrollmentPanel(EnrollmentView enrollmentView) {
			selectStudent = new JButton("Select Student");
			add = new JButton ("add");
			drop = new JButton("drop");
			enrollmentTable = new MyTable(headers);
			add(selectStudent); add(add); add(drop);
			add(enrollmentTable);
		}
		
	}

}
