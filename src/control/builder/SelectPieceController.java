package control.builder;

import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import boundary.builder.BuilderBoardPanel;
import boundary.builder.BuilderBullpenPanel;
import entity.player.Bullpen;
import entity.player.Piece;
/**
 * Class responsible for getting a piece out of the bullpen.
 * 
 * @author Nathan
 *
 */
public class SelectPieceController extends MouseAdapter {

	Bullpen bullpen;
	BuilderBoardPanel boardView;
	BuilderBullpenPanel bullpenView;
	JRadioButton movePieces;
	/**
	 * Constructor for SelectPieceController
	 * @param bp - Current bullpen
	 * @param boardv - Current board view
	 * @param bullv - Current bullpen view
	 * @param b - move pieces button
	 */
	public SelectPieceController(Bullpen bp, BuilderBoardPanel boardv, BuilderBullpenPanel bullv, JRadioButton b){
		bullpen = bp;
		boardView = boardv;
		bullpenView = bullv;
		movePieces = b;
	}

	/**
	 * selects the piece in the bullpen for moving on the board.
	 */
	public void mousePressed (MouseEvent me) {
		if(movePieces.isSelected()){//only want to do this if we are moving pieces
			Piece p = bullpenView.getPieceAtCoordinate(me.getPoint());
			if(p == null){
				Piece selected = bullpen.getSelectedPiece();
				if(selected != null){
					bullpen.addPiece(selected);
					bullpen.removeSelected();
					bullpenView.redraw();
					bullpenView.repaint();
					boardView.redraw();
					boardView.repaint();
				}
				return;
			}
			// if this is the selected piece, add it to the bullpen
			if(bullpen.getSelectedPiece() != null){
				bullpen.addPiece(bullpen.getSelectedPiece());
			}
			bullpen.setSelected(p);
			bullpen.removePiece(p);
			bullpenView.redraw();
			bullpenView.repaint();
			boardView.redraw();
			boardView.repaint();
		}
	}
	
	
}
