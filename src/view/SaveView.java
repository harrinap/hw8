package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.SaveController;

public class SaveView extends JFrame {

	JButton saveButton;

	public SaveView() {

		// setTitle("Save");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(20, 480);
		// setSize(20,20);
		saveButton = new JButton("Save and Exit");
		this.add(saveButton);
		pack();
		setVisible(true);
	}

	public void addSaveButtonListener(ActionListener saveListener) {
		saveButton.addActionListener(saveListener);

	}

}
