package control.player;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import boundary.builder.BuilderBoardPanel;
import bounday.player.PlayerBoardPanel;
import entity.player.Board;
import entity.player.Level;
import entity.player.Piece;
import entity.player.PuzzleLevel;

/**
 * Places active piece on board or picks up a piece on the board.
 * Suitable for Puzzle Levels.
 * (Nearly identical to the builder version)
 * 
 * @author Nathan
 *
 */
public class PlacePuzzlePieceController implements MouseListener {
	
	PuzzleLevel model;
	PlayerBoardPanel boardView;
	JLabel movesLeft;
	JLabel stars;
	/**
	 * Constructor for PlacePuzzlePieceController
	 * @param l - Current level model
	 * @param bv - Current board panel
	 * @param ml - Moves left label
	 * @param s - Stars label
	 */
	public PlacePuzzlePieceController(PuzzleLevel l, PlayerBoardPanel bv, JLabel ml, JLabel s){
		model = l;
		boardView = bv;
		movesLeft = ml;
		stars = s;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		return;
		
	}

	@Override
	/**
	 * when the mouse is left clicked, we want to place a piece if it is active or 
	 * pick up a piece if there is nothing active.
	 */
	public void mousePressed(MouseEvent e) {
		//only do this if you are left clicking (and the move piece button is selected)
		if(e.getButton() == MouseEvent.BUTTON1){
			if(model.getMovesLeft() > 0){ //only if there are allowed moves left
				Piece adding = model.getBullpen().getSelectedPiece();
				Board b = model.getBoard();
				Point clicked = boardView.getRowCol(e.getPoint());
				if(clicked == null){return;}
				if(adding == null){
					//this means you are trying to pick up a piece.
					Piece picked = b.getPiece(clicked.x,clicked.y);
					if(picked==null){return;}
					b.removePiece(clicked.x, clicked.y);
					model.getBullpen().setSelected(picked);
					model.updateStars();
					boardView.redraw();
					boardView.repaint();
				} else {
					//you are trying to place a piece
					if(b.addPiece(clicked.x, clicked.y, adding)){
						//you are successfully placing a piece.
						model.getBullpen().getSelectedPiece().onBoard();
						model.getBullpen().removeSelected();
						Integer moves = model.getMovesLeft() - 1;
						model.setMovesLeft(moves);
						model.updateStars();
						movesLeft.setText(moves.toString());
						boardView.redraw();
						boardView.repaint();
					}
				}
			}
		}
		if(model.getStars() == 0){
			stars.setIcon(null);
		}
		if(model.getStars() == 1){
			stars.setIcon(new ImageIcon(PlacePuzzlePieceController.class.getResource("/images/OneStar.png")));
		}
		if(model.getStars() == 2){
			stars.setIcon(new ImageIcon(PlacePuzzlePieceController.class.getResource("/images/TwoStars.png")));
		}
		if(model.getStars() == 3){
			stars.setIcon(new ImageIcon(PlacePuzzlePieceController.class.getResource("/images/ThreeStars.png")));
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		return;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		return;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;
		
	}

}
