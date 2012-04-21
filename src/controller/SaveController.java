package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import view.SaveView;

import model.Model;
import model.SaveObject;

public class SaveController {

	Model model;

	public SaveController(Model model, SaveView s) {

		this.model = model;
		s.addSaveButtonListener(new SaveListener());
	}

	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			save(model.getSaveObject());
			System.exit(0);
		}
	}

	private void save(SaveObject model) {
		String fileName = "model.ser";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(model);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
