package Moves;

import control.builder.IMove;
import entity.player.Board;
import entity.player.Bullpen;
import entity.player.Piece;
/**
 * Captures a move from Board to Bullpen
 * @author Drew
 *
 */
public class PieceMoveToBP implements IMove {

	Integer startX;
	Integer startY;
	Board b;
	Bullpen bP;
	Piece aPiece;

	public PieceMoveToBP(Integer startX, Integer startY, Board b, Bullpen bP, Piece P) {
		this.startX = startX;
		this.startY = startY;
		this.b = b;
		this.bP = bP;
		this.aPiece = P;
	}
/**
 * Undoes a move from the bullpen to board
 */
	@Override
	public boolean undo() {
		b.addPiece(startX, startY, aPiece);
		
		bP.removePiece(aPiece);
		return true;
	}
@Override
public void redo() {
	bP.addPiece(aPiece);
	b.removePiece(startX, startY);
	
	
}
}