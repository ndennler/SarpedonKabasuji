package Moves;

import control.builder.IMove;
import entity.player.Bullpen;
import entity.player.Piece;
/**
 * Captures a move to the stock
 */
public class ToStockMove implements IMove{
	Bullpen bP;

	Piece aPiece;

	public ToStockMove(Bullpen bP, Piece aPiece){
		this.bP=bP;
		
		this.aPiece = aPiece;
	}
	/**
	 * Undoes a move to the stock.
	 */
	public boolean undo()
	{
		bP.addPiece(aPiece);
		return true;
	}
	@Override
	public void redo() {
		bP.removePiece(aPiece);
		
	}

}
