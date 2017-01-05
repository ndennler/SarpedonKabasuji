package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JTextField;

import boundary.builder.LightningBuilderGui;
import boundary.builder.LoadGui;
import boundary.builder.PuzzleBuilderGui;
import boundary.builder.ReleaseBuilderGui;
import entity.builder.BuildableLightning;
import entity.builder.BuildablePuzzle;
import entity.builder.BuildableRelease;
import entity.player.LevelMomento;
/**
 * Loads the existing file for editing in the Builder application.
 * 
 * @author Nathan
 *
 */
public class LoadExistingToEditController implements ActionListener{
	JTextField fileNameText;
	LoadGui loadGui;
	/**
	 * Constructor for LoadExistingToEditController
	 * @param t - Given text
	 * @param load - Load GUI
	 */
	public LoadExistingToEditController(JTextField t, LoadGui load){
		fileNameText = t;
		loadGui = load;
	}

	@Override
	/**
	 * loads the level specified in the textfield, and determines which builder it should use.
	 */
	public void actionPerformed(ActionEvent e) {
		if(fileNameText.getText() == null){fileNameText.setText("Please Enter a Valid Level Name");}
		try{		
			String fileName = fileNameText.getText() + ".ext";
			ObjectInputStream restore = new ObjectInputStream(new FileInputStream(fileName));
			LevelMomento obj = (LevelMomento) restore.readObject();
			restore.close();
		
			String type = obj.getType();
			
			if(type.equals("Puzzle")){
				BuildablePuzzle model = new BuildablePuzzle();
				model.restore(obj);
				PuzzleBuilderGui gui = new PuzzleBuilderGui(model);
				gui.setVisible(true);
				loadGui.setVisible(false);
			}
			if(type.equals("Lightning")){
				BuildableLightning model = new BuildableLightning();
				model.restore(obj);
				LightningBuilderGui gui = new LightningBuilderGui(model);
				gui.setVisible(true);
				loadGui.setVisible(false);
			}
			if(type.equals("Release")){
				BuildableRelease model = new BuildableRelease();
				model.restore(obj);
				ReleaseBuilderGui gui = new ReleaseBuilderGui(model);
				gui.setVisible(true);
				loadGui.setVisible(false);
			} else {
				fileNameText.setText("Type Not Recognized: Try Again");
			}
			
		} catch(Exception ex){
			fileNameText.setText("File Not Found; Try Again");
		}
	}
}
