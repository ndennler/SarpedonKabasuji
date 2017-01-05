package Moves;

import control.builder.IMove;
import entity.player.Bullpen;
import entity.player.Piece;
import entity.player.PieceBuilder;

/**
 * 
 * @author Drew
 * A Piece moving from stock to bullpen
 */
public class FromStockMove implements IMove{
	Bullpen bP;

	Piece aPiece;
	public FromStockMove(Bullpen bP, Piece aPiece){
		this.bP=bP;
		
		this.aPiece = aPiece;
	}
	/**
	 * Will return a piec to the stock that was in bullpen
	 */
	public boolean undo()
	{
		bP.removePiece(aPiece);
		return true;
	}
	@Override
	public void redo() {
		bP.addPiece(aPiece);
		
	}
}
