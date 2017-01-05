package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import entity.builder.IBuilderModel;
import entity.player.Level;
import entity.player.LevelMomento;
/**
 * Allows the saving of a Level as a level momento
 * @author Drew 
 *
 */
public class SaveController implements ActionListener {

	LevelMomento aLevel;
	JTextField aText;
	IBuilderModel model;
	/**
	 * Constructor for SaveController
	 * @param aText - Text
	 * @param model - Current model
	 */
	public SaveController(JTextField aText, IBuilderModel model) {
		this.aText = aText;
		this.model = model;

	}
	/**
	 * handles saving a level momento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			aLevel = new LevelMomento(model);
			File aFile = new File (aText.getText()+".ext");

			FileOutputStream saveFile = new FileOutputStream(aFile);
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(aLevel);
			save.close();
			System.exit(0);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

}

