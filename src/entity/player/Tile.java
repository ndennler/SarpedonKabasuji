package entity.player;

import java.io.Serializable;
import java.util.UUID;
/**
 *  A basic component of a board.
 *  Contains the row and column where the tile is located as well as a unique identifier
 *  for the Piece covering the Tile or null if the Tile is not covered by a Piece.
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class Tile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/** the row in where the lower right corner of the tile is */
	Integer row; 
	/** the column in where the lower right corner of the tile is */
	Integer col;
	/** the unique ID of the piece covering it */
	protected UUID coveredBy; 
	
	/** Constructor with UUID provided 
	 * @param rw the row in which the Tile is located
	 * @param cl the column in which the Tile is located
	 * @param cvrd the UUID of the piece that covers the Tile, or null if there is no Piece covering the Tile 
	 */
	public Tile(Integer rw, Integer cl, UUID cvrd){
		row = rw;
		col = cl;
		coveredBy = cvrd;
	}
	/** Constructor without UUID 
	 * @param rw the row in which the Tile is located
	 * @param cl the column in which the Tile is located
	 */
	public Tile(Integer rw, Integer cl){
		row = rw;
		col = cl;
		coveredBy = null;
	}
	
	/** Gets the row location of the Tile */
	public Integer getRow(){
		return this.row;
	}
	/** Gets the column location of the Tile */
	public Integer getColumn(){
		return this.col;
	}
	
	/** Gets the UUID of the Piece that covers the Tile */
	public UUID getCoveredBy(){
		return this.coveredBy;
	}
	
	/** Sets the UUID of the Piece that covers the Tile */
	public void setCoveredBy(UUID i){
		this.coveredBy = i;	
	}
	
	/** Checks if a location is over the tile, returns true if it is 
	 * @param rw the row in which to check
	 * @param cl the column in which to check
	 */
	boolean overTile(Integer rw, Integer cl){
		if ((rw <= this.row) && (rw > (this.row - 1)) && (cl <= this.col) && (cl > (this.col -1))){
			return true;
		}
		else return false;
	}

}
