package control.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Moves.RotateFlipMove;
import entity.builder.IBuilderModel;
import entity.player.*;
import boundary.builder.*;

//import javax.swing.*;
/**
 * Flips the active piece.
 * true is vertical false is horizontal.
 * 
 * @author Nathan
 *
 */
public class FlipController implements ActionListener{

	BuilderBoardPanel boardPanel;
	IBuilderModel model;
	Boolean direction;
	/**
	 * Constructor for FlipController
	 * @param newBoardPanel - Current board panel
	 * @param bm - Current model
	 * @param newdirection - Given direction
	 */
	public FlipController(BuilderBoardPanel newBoardPanel, IBuilderModel bm, Boolean newdirection){
		boardPanel = newBoardPanel;
		model = bm;
		direction = newdirection;
	}

	@Override
	/**
	 * flips active piece in the specified direction.
	 * Note: piece may come from board unlike playable levels.
	 */
	public void actionPerformed(ActionEvent e) {
		
		Piece piece = model.getBullpen().getSelectedPiece();
		if (piece == null){return;}
		if (direction){
			piece.flipVertical();
			IMove aMove = new RotateFlipMove(piece, "Vertical");
			model.addMove(aMove);
		} else {
			piece.flipHorizontal();
			IMove aMove = new RotateFlipMove(piece, "Horizontal");
			model.addMove(aMove);
		}
		model.getBullpen().setSelected(piece);
		boardPanel.redraw();
		boardPanel.repaint();
	}
}