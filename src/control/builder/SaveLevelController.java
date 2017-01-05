package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import boundary.builder.SaveGui;
import entity.builder.IBuilderModel;

/**
 * Determines if the level is ready to be saved.
 * 
 * would not be ready if:
 * -pieces are still on board
 * -there is still a selected piece being hovered over the board.
 * 
 * @author Nathan
 *
 */
public class SaveLevelController implements ActionListener{

	JLabel warning;
	IBuilderModel model;
	JFrame currentGui;
	/**
	 * Constructor for SaveLevelController
	 * @param w - Warning label
	 * @param m - Current model
	 * @param c - Current GUI
	 */
	public SaveLevelController(JLabel w, IBuilderModel m, JFrame c){
		warning = w;
		model = m;
		currentGui = c;
	}
	/**
	 * Handles writing warning labels should a level not be ready to save
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(model.getBullpen().getSelectedPiece() != null){warning.setText("Please place the selected piece in the bullpen."); return;}
		if(model.getBoard().spacesLeft() != model.getBoard().getSize()){
			warning.setText("Please remove all pieces from board");
			return;
		}
		currentGui.dispose();
		new SaveGui(model).setVisible(true);
	}
	
	
}
