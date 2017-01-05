package entity.player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

/**
 * A Board entity object.
 * Contains:
 * shape = a two dimensional array with tiles where the board is playable and null, elsewhere
 * pieces = a hash of UUIDs to pieces
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class Board implements Serializable{
	private static final long serialVersionUID = -6584127615090719915L;
	/** an array of tiles or null describing the shape of the board 
	 * playable locations on the board are represented by a tile 
	 * non playable locations on the board are marked with null */
	protected Tile[][] shape; 
	/** a mapping of pieces to uuid's stored in tiles */
	protected HashMap <UUID, Piece> pieces; 
	
	 boolean movingTile = false;
	/** default constructor
	 *  produces a 12 x 12 board of Tiles, none of which are covered */
	public Board(){
		shape = new Tile[12][12];
		for(int i=0; i< 12; i++){
			for(int j =0; j<12;j++){
				shape[i][j]	= new Tile(i,j);
			}
		}
		pieces = new HashMap<UUID, Piece>();
	}
	
	/** Constructor taking a two dimensional array of Tiles describing the shape
	 * @param s a two dimensional array of Tiles describing the shape
	 * nulls at a given array location indicate the location is never playable
	 */
	public Board(Tile[][] s){
		// enforce size restriction, array must be at least 1 x 1 and less than 12 x 12
		if ((s.length <= 12)&&(s.length>=1)){
			if ((s[0].length <= 12)&&(s[0].length >=1)){
				shape = s;
				}
		} else {
			throw new RuntimeException("entity.player::Board: invalid board array");
		}
		pieces = new HashMap<UUID, Piece>();
	}

	/** looks up the Piece covering a given location
	 * @param row the row in which to look
	 * @param col the column in which to look
	 * @return null if no Piece present at that location, otherwise returns the Piece */
	public Piece getPiece(Integer row, Integer col){
		Tile t = shape[row][col];
		if(t == null){return null;}
		UUID tUUID = t.getCoveredBy();
		if (tUUID != null){
			Piece p = pieces.get(tUUID);
			return p;
		} else {
			return null; 
		}
	}
	
	/** Getter for shape */
	public Tile[][] getTileArray(){
		return shape;
	}
	
	/** Getter for whether there is a moving Tile */
	public boolean getMovingTile(){
		return movingTile;
	}
	
	/** Sets whether there is a moving Tile */
	public void setMovingTile(boolean b){
		movingTile = b;
	}
	/** Getter for the tile at a specific row an column location 
	 * @param row the row in which the tile is located
	 * @param col the column in which the tile is located
	 */
	public Tile getTile(int row, int col){
		return shape[row][col];
	}
	/** updates the Board with the information of a new Tile
	 * @param t the new Tile for the Board*/
	public void setTile(Tile t){
		shape[t.getRow()][t.getColumn()] = t;
	}
	/** removes a Tile from the board at the given location, making it unplayable 
	 * @param row the row in which the Tile is to be removed
	 * @param column the column in which the Tile is to be removed
	 */
	public void removeTile(int row, int column){
		shape[row][column] = null;
	}
	/** 
	 * Returns whether a Tile is available for a new Piece at a column, row position 
	 * @param row the row in which the Tile is located
	 * @param col the column in which the Tile is located
	 * @return boolean representing whether the move was successful
	 */
	public boolean availableTile(Integer row, Integer col){
		// check if out of bounds of rectangular representation of the board
		if ((row > shape[0].length - 1) || (col > shape.length - 1)){
			return false;
		}
		if ((row < 0) || (col < 0)){
			return false;
		}
		Tile t = shape[row][col];
		if (t == null){
			return false; // location not a playable tile
		}
		UUID tUUID = t.getCoveredBy();
		if (tUUID != null){
			return false; // tile already covered by another piece
		}
		else {
			return true; 
		}
	}
	/** 
	 * Returns whether a given piece can be placed at a column, row position 
	 * @param row the row in which the location of interest lies
	 * @param col the column in which the location of interest lies
	 * @param p the prospective Piece for that location
	 * @return boolean representing whether the move was successful
	 */
	protected boolean piecePlaceable(Integer row, Integer col, Piece p){
		boolean placeable = true;
		//if (availableTile(row, col)){
			for (Square s : p.getDependent()){
				int dcol = col + s.getyFromAnchor();
				int drow = row + s.getxFromAnchor();
				if (!availableTile(drow, dcol)){
					placeable = false;
				}
			}
		//}
		//else {
		//	placeable = false;
		//}
		return placeable;
	}
	
	/** 
	 * adds a Piece to the Board, updates the hash and Tiles 
	 * @param row the row in which the Piece is to be placed
	 * @param col the column in which the Piece is to be placed
	 * @param p the Piece which is to be placed
	 * @return boolean representing whether the add was successful
	 */
	public boolean addPiece(Integer row, Integer col, Piece p){
		if (this.piecePlaceable(row, col, p)){
			UUID pUUID = UUID.randomUUID(); // generating UUID for hash
			while (this.pieces.get(pUUID) != null){ // ensuring a unique UUID
				pUUID = UUID.randomUUID();
			}
			Tile t = this.shape[row][col];
			//t.setCoveredBy(pUUID); // mark the tile under the anchor as covered by the tile with this UUID
			//not needed because after some rotations the anchor is not necessarily under the mouse.
			for (Square s : p.getDependent()){ // mark the rest 
				int dcol = col + s.getyFromAnchor();
				int drow = row + s.getxFromAnchor();
				t = this.shape[drow][dcol];
				t.setCoveredBy(pUUID);
			
				}
			pieces.put(pUUID, p); // put mapping into hashmap
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * If a piece is present at a location on the Board removes it
	 * @param row the row of the intended removal
	 * @param col the column of the intended removal
	 * @return boolean representing whether the remove was successful or false if there was no piece
	 */
	public boolean removePiece(Integer row, Integer col){
		Tile t = shape[row][col];
		if (t == null){ return false;}
		UUID pUUID = t.getCoveredBy();
		if (pUUID != null){ // check if tile is covered
			for (Tile[] tileRow: shape){ // update coveredBy for tiles in shape
				for (Tile aTile: tileRow){
					if(aTile != null){
						if (aTile.getCoveredBy() == pUUID){
							aTile.setCoveredBy(null);
						}
					}
				}
			}
			pieces.remove(pUUID); // remove mapping from hash
			return true;
		}
		else { // tried to remove a piece from a tile that is not covered
			return false;
		}
	}
	/**
	 * Moves a piece from one place to another on a board
	 * @param startRow the starting row of the intended move
	 * @param startCol the starting column of the intended move
	 * @param endRow the destination row of the intended move
	 * @param endCol the destination column of the intended move
	 * @return boolean representing whether the move was successful
	 */
	boolean movePiece(Integer startRow, Integer startCol, Integer endRow, Integer endCol){
		Piece p = getPiece(startRow, startCol);
		if (p!= null){ // check that there is a piece at the start location
			if(piecePlaceable(endRow, endCol, p)){ // check that the end location is placeable
				addPiece(endRow, endCol, p); // add the piece to the new location
				removePiece(startRow, startCol); // remove the piece from the old location
				return true;
			}
			else {
				return false; // end location not valid
			}
		}
		else {
			return false; // there was no starting piece
		}
	}
	/**
	 * Removes all of Pieces from the board.
	 */
	void removeAll(){
		for (Tile[] tileRow: shape){ // clear coveredBy for all tiles
			for (Tile aTile: tileRow){
				if (aTile != null){
					aTile.setCoveredBy(null);
				}
			}
		}
		pieces.clear();	 // removes all mappings from hashmap
	}
	/**
	 * Returns the number of tiles in the board.
	 * @return int representing how many tiles in the board
	 */
	public int getSize() {
		int size = 0;
		for (Tile[] tileRow: shape){ // clear coveredBy for all tiles
			for (Tile aTile: tileRow){
				if (aTile != null){
					size++;
				}
			}
		}
		return size;
	}

	/** returns number of spaces left uncovered. */
	public int spacesLeft(){
		int sL = 0;


		for(int i = 0; i<12; i++){
			for(int j = 0; j <12; j++){
				if(availableTile(i, j)){
					if(shape[i][j].coveredBy == null){
						sL++;
					}
				}
			}
		}
		return sL;
	}
	
}
