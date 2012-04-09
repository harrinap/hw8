import javax.swing.JButton;
import javax.swing.JFrame;


public class SaveView extends JFrame {

	SaveController saveController;
	
	public SaveView(SaveController saveController) {
		this.saveController = saveController;
		setTitle("Save");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocation(200,200);
	  	//setSize(20,20);
	    JButton saveButton = new JButton("Save and Exit");
	    this.add(saveButton);
	    pack();
	    setVisible(true);
	}

}
