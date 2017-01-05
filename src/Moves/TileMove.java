package Moves;

import control.builder.IMove;
import entity.player.Board;
import entity.player.Tile;
/**
 * captures a movement of a tile to a new location
 * @author Drew
 *
 */
public class TileMove implements IMove{
Tile start;
Tile end;
Board aBoard;
	public TileMove(Tile start, Tile end, Board aBoard){
		this.start= start;
		this.end = end;
		this.aBoard = aBoard;
	}

	
	/**
	 * undoes a movement of a tile to a new location
	 * 
	 */
	@Override
	public boolean undo() {
		aBoard.removeTile(end.getRow(), end.getColumn());
		aBoard.setTile(start);
		return true;
	}


	@Override
	public void redo() {
		aBoard.removeTile(start.getRow(), start.getColumn());
		aBoard.setTile(end);
		
	}
}
