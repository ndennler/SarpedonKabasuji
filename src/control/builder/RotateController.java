package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Moves.RotateFlipMove;
import entity.builder.IBuilderModel;
import entity.player.*;
import boundary.builder.*;

//import javax.swing.*;
/**
 * Rotates the active Piece.
 * true is a counter clockwise rotation, false is a clockwise rotation
 * @author Nathan
 *
 */
public class RotateController implements ActionListener{

	IBuilderModel model;
	BuilderBoardPanel boardPanel;
	boolean direction;
	/**
	 * Constructor for RotateController
	 * @param newBoardPanel - Current board panel
	 * @param bm - Current model
	 * @param newdirection - direction
	 */
	public RotateController(BuilderBoardPanel newBoardPanel, IBuilderModel bm, Boolean newdirection){
		boardPanel = newBoardPanel;
		model = bm;
		direction = newdirection;
	}
	
	public void rotate(boolean direction){

	}

	@Override
	/**
	 * rotate piece to see how it will fit in the board.
	 * Unlike the Player version, the piece may come from the board.
	 */
	public void actionPerformed(ActionEvent e) {
		Piece piece = model.getBullpen().getSelectedPiece();
		if (piece == null){return;}
		if (direction){
			piece.rotateCounterClockwise();
			IMove aMove = new RotateFlipMove(piece, "Counter");
			model.addMove(aMove);
		} else {
			piece.rotateClockwise();
			IMove aMove = new RotateFlipMove(piece, "Clockwise");
			model.addMove(aMove);
		}
		model.getBullpen().setSelected(piece);
		boardPanel.redraw();
		boardPanel.repaint();
		
	}
}
