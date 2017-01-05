package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import entity.builder.BuildablePuzzle;
/**
 * changes the number of moves the level allows
 * 
 * @author Nathan
 *
 */
public class UpdateMovesController implements ActionListener{

	JTextField moves;
	BuildablePuzzle model;
	JLabel error;
	/**
	 * Constructor for UpdateMovesController
	 * @param tf - input number of moves
	 * @param m - Current model
	 * @param e - Error label
	 */
	public UpdateMovesController(JTextField tf, BuildablePuzzle m, JLabel e){
		moves = tf;
		model = m;
		error = e;
	}
	
	@Override
	/**
	 * Get the number of moves typed in and update the level.
	 */
	public void actionPerformed(ActionEvent e) {
		try{
		Integer totalMoves = Integer.valueOf(moves.getText());
		model.setMovesAllotted(totalMoves);
		} catch(NumberFormatException string){
			error.setText("Please enter a valid number.");
		}
		
	}
	

	
}
