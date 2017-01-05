package control.builder;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JRadioButton;

import Moves.PieceMoveToBP;
import Moves.PieceMoveToBoard;
import boundary.builder.BuilderBoardPanel;

import entity.builder.IBuilderModel;
import entity.player.Board;
import entity.player.Piece;
import entity.player.Tile;
/**
 * Places selected piece on the board.
 * Will also pick up a piece if there is no selected piece.
 * 
 * @author Nathan
 *
 */
public class PlacePieceController implements MouseListener{
	
	IBuilderModel model;
	BuilderBoardPanel boardView;
	JRadioButton movePieces;
	Integer startX;
	Integer startY;
	/**
	 * Constructor for PlacePieceController
	 * @param bm - Current model
	 * @param bv - Current board panel
	 * @param b - move pieces button
	 */
	public PlacePieceController(IBuilderModel bm, BuilderBoardPanel bv, JRadioButton b){
		model = bm;
		boardView = bv;
		movePieces = b;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		return;
		
	}

	@Override
	/**
	 * Place a piece at the given location on the board.
	 */
	public void mousePressed(MouseEvent e) {
		//only do this if you are left clicking (and the move piece button is selected)
		if(e.getButton() == MouseEvent.BUTTON1 && movePieces.isSelected()){
			Piece adding = model.getBullpen().getSelectedPiece();
			Board b = model.getBoard();
			Point clicked = boardView.getRowCol(e.getPoint());
			if(clicked == null){return;}
			if(adding == null){
				//this means you are trying to pick up a piece.
				Piece picked = b.getPiece(clicked.x,clicked.y);
				if(picked==null){return;}
				
				IMove aMove = new PieceMoveToBP(clicked.x, clicked.y, model.getBoard(), model.getBullpen(), picked);
				model.addMove(aMove);
				b.removePiece(clicked.x, clicked.y);
				model.getBullpen().setSelected(picked);
				boardView.redraw();
				boardView.repaint();
			} else {
				//you are trying to place a piece
				if(b.addPiece(clicked.x, clicked.y, adding)){
					IMove aMove = new PieceMoveToBoard(clicked.x, clicked.y, model.getBoard(), model.getBullpen(), adding);
					model.addMove(aMove);
					model.getBullpen().removeSelected();
			
			startX =  null;
			startY =  null;
					boardView.redraw();
					boardView.repaint();
				}
			}
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
